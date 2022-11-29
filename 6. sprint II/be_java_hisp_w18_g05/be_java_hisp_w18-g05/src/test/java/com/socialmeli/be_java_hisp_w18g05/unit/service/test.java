package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.socialmeli.be_java_hisp_w18g05.utils.test.*;

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

        iRepository.addFollowed(buyer, seller);
        iRepository.addFollower(buyer, seller);
        verify(iRepository,times(1)).addFollower(buyer, seller);
        verify(iRepository,times(1)).addFollowed(buyer, seller);
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
    @DisplayName("T-0004 - Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0003)")
    void test0004Asc0803() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_asc";
        Seller sellerMock = getSellerWithListOrderAsc(userId); // utils static method
        List<Buyer> expected = sellerMock.getFollowers();
        //========= Mock =============
        when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
        //========= Act  =============
        List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0003)")
    void test0004Desc0803() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_desc";
        Seller sellerMock = getSellerWithListOrderDesc(userId); // utils static method
        List<Buyer> expected = sellerMock.getFollowers();
        //========= Mock =============
        when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
        //========= Act  =============
        List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0004)")
    void test0004Asc0804() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_asc";
        Buyer buyerMock = getBuyerWithListOrderAsc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0004 - Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0004)")
    void test0004Desc0804() {
        //========= Arrange ==========
        Integer userId = 1;
        String order = "name_desc";
        Buyer buyerMock = getBuyerWithListOrderDesc(userId); // utils static method
        List<Seller> expected = buyerMock.getFolloweds();
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
        );
    }

    @Test
    @DisplayName("T-0006 - Verificar el correcto ordenamiento por fecha ascendente. (US-0009)")
    void test0006Asc(){
        //========= Arrange =============
        Integer userId = 1;
        String order = "date_asc";
        List<Seller> sellerList = new ArrayList<>();
        // Utilizamos un objectMapper
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // lista de post del seller 10
        List<Post> postList1 = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now().minusDays(11), new Product(10, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post2 = new Post(2, LocalDate.now().minusDays(10), new Product(22, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post3 = new Post(3, LocalDate.now().minusDays(6), new Product(33, "Name", "type", "brand", "color", "notes"), 100, 25D);
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        Post post4 = new Post(4, LocalDate.now().minusDays(4), new Product(44, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post5 = new Post(5, LocalDate.now().minusDays(1), new Product(55, "Name", "type", "brand", "color", "notes"), 100, 25D );
        postList2.add(post4);
        postList2.add(post5);
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        // Creamos comprador con la lista de sellers que sigue
        Buyer buyerMock = new Buyer(userId, "Buyer1", sellerList);
        // Creamos el expected con los post como deberían estar ordenados.
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, post1.getPost_id(), post1.getDate().toString(), op.convertValue(post1.getProduct(), ProductDTOResponse.class), post1.getCategory(), post1.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post2.getPost_id(), post2.getDate().toString(), op.convertValue(post2.getProduct(), ProductDTOResponse.class), post2.getCategory(), post2.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post3.getPost_id(), post3.getDate().toString(), op.convertValue(post3.getProduct(), ProductDTOResponse.class), post3.getCategory(), post3.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post4.getPost_id(), post4.getDate().toString(), op.convertValue(post4.getProduct(), ProductDTOResponse.class), post4.getCategory(), post4.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post5.getPost_id(), post5.getDate().toString(), op.convertValue(post5.getProduct(), ProductDTOResponse.class), post5.getCategory(), post5.getPrice()));
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(userId, postDTOResponseList);
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
        );
    }

    @Test
    @DisplayName("T-0006 - Verificar el correcto ordenamiento por fecha descendente. (US-0009)")
    void test0006Desc(){
        //========= Arrange ==========
        Integer userId = 1;
        String order = "date_desc";
        List<Seller> sellerList = new ArrayList<>();
        // Utilizamos un objectMapper
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // lista de post del seller 10
        List<Post> postList1 = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now().minusDays(6), new Product(10, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post2 = new Post(2, LocalDate.now().minusDays(8), new Product(22, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post3 = new Post(3, LocalDate.now().minusDays(10), new Product(33, "Name", "type", "brand", "color", "notes"), 100, 25D);
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        Post post4 = new Post(4, LocalDate.now().minusDays(11), new Product(44, "Name", "type", "brand", "color", "notes"), 100, 25D );
        Post post5 = new Post(5, LocalDate.now().minusDays(13), new Product(55, "Name", "type", "brand", "color", "notes"), 100, 25D );
        postList2.add(post4);
        postList2.add(post5);
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        // Creamos comprador con la lista de sellers que sigue
        Buyer buyerMock = new Buyer(userId, "Buyer1", sellerList);
        // Creamos el expected con los post como deberían estar ordenados.
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, post1.getPost_id(), post1.getDate().toString(), op.convertValue(post1.getProduct(), ProductDTOResponse.class), post1.getCategory(), post1.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post2.getPost_id(), post2.getDate().toString(), op.convertValue(post2.getProduct(), ProductDTOResponse.class), post2.getCategory(), post2.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, post3.getPost_id(), post3.getDate().toString(), op.convertValue(post3.getProduct(), ProductDTOResponse.class), post3.getCategory(), post3.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post4.getPost_id(), post4.getDate().toString(), op.convertValue(post4.getProduct(), ProductDTOResponse.class), post4.getCategory(), post4.getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, post5.getPost_id(), post5.getDate().toString(), op.convertValue(post5.getProduct(), ProductDTOResponse.class), post5.getCategory(), post5.getPrice()));
        SellerPostListDTOResponse expected = new SellerPostListDTOResponse(userId, postDTOResponseList);
        //========= Mock =============
        when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
        //========= Act ==============
        SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
        //========= Asserts ==========
        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
        );
    }

}

