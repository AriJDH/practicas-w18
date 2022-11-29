package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.PostDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ProductDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerPostListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class test {

    @Mock
    IRepository iRepository;
    @InjectMocks
    ServiceImp serviceImp;

    @Test
    @DisplayName("T-0001 // Add follow, OK")
    public void addFollowOk(){
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");

        lenient().when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);
        lenient().when(iRepository.getByIdBuyer(buyer.getUser_id())).thenReturn(buyer);

        iRepository.addFollowed(buyer,seller);
        iRepository.addFollower(buyer,seller);
        verify(iRepository,times(1)).addFollower(buyer,seller);
        verify(iRepository,times(1)).addFollowed(buyer,seller);
    }

    @Test
    @DisplayName("T-0001 // Add follow, seller doesn't exist")
    public void addFollowSellerDoesntExist(){
        lenient().when(iRepository.getByIdSeller(1)).thenReturn(null); // averiguar que es lenient

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, 10));
    }

    @Test
    @DisplayName("T-0001 // Add follow, buyer doesn't exist")
    public void addFollowBuyerDoesntExist(){
        lenient().when(iRepository.getByIdBuyer(10)).thenReturn(null); // averiguar que es lenient

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, 10));
    }

    @Test
    @DisplayName("T-0001 // Add follow, buyer and seller don't exist")
    public void addFollowBuyerAndSellerDontExist(){
        lenient().when(iRepository.getByIdSeller(1)).thenReturn(null);
        lenient().when(iRepository.getByIdBuyer(10)).thenReturn(null);

        Assertions.assertAll(
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(1, null)),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, 10))
        );
    }

    @Test
    @DisplayName("T-0007 // Followers count is correct, user id exists")
    public void followersCountTest(){
        //Arrange
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");
        Buyer buyer2 = new Buyer(2,"Buyer2");

        when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);

        List<Buyer> listaFollowers =new ArrayList<>();
        listaFollowers.add(buyer);
        listaFollowers.add(buyer2);
        Integer tamano= listaFollowers.size();

        SellerFollowersCountDTOResponse expected= new SellerFollowersCountDTOResponse(seller.getUser_id(), seller.getName(), tamano);

        //Act
        seller.addFollower(buyer);
        seller.addFollower(buyer2);
        SellerFollowersCountDTOResponse result= serviceImp.followersCount(seller.getUser_id());

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0007 // Followers count is correct, user id not exists")
    public void followersCountTestNotExist(){
        //Arrange
        when(iRepository.getByIdSeller(1)).thenReturn(null);

        //Act
        //Assert

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.followersCount(1));
    }

    @Test
    @DisplayName("T-0008 // Verify post since 2 weeks ago")
    public void postTwoWeeks(){
        //Arrange
        Buyer buyer = new Buyer(1,"Buyer1");
        Seller seller = new Seller(10,"Seller10");
        Seller seller2 = new Seller(20,"Seller20");

        Product product1= new Product(1,"silla","gamer","racer","red","special");
        Product product2= new Product(1,"silla2","gamer2","racer2","red2","special2");
        Post post1=new Post(1,LocalDate.now().minusDays(7),product1,100,1500.50);
        Post post3=new Post(2,LocalDate.now().minusDays(30),product2,100,1500.50);
        Post post2=new Post(3,LocalDate.now().minusDays(11),product2,200,2500.50);

        ProductDTOResponse product11= new ProductDTOResponse(1,"silla","gamer","racer","red","special");
        ProductDTOResponse product22= new ProductDTOResponse(1,"silla2","gamer2","racer2","red2","special2");
        PostDTOResponse post11=new PostDTOResponse(10,1,LocalDate.now().minusDays(7),product11,100,1500.50);
        PostDTOResponse post33=new PostDTOResponse(20,2,LocalDate.now().minusDays(30),product22,100,1500.50);
        PostDTOResponse post22=new PostDTOResponse(10,3,LocalDate.now().minusDays(11),product22,200,2500.50);

        seller.addPost(post1);
        seller.addPost(post3);
        seller2.addPost(post2);

        List<PostDTOResponse> expected=new ArrayList<>();
        expected.add(post11);
        expected.add(post33);
        expected.add(post22);

        when(iRepository.getByIdBuyer(1)).thenReturn(buyer);

        //Act
        buyer.addFollowed(seller);
        buyer.addFollowed(seller2);
        SellerPostListDTOResponse result= serviceImp.orderByDate(buyer.getUser_id(),"date_asc");

        //Assert
        Assertions.assertEquals(expected,result);
    }
}
