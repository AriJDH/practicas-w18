package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.PostDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ProductDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
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
import java.util.Date;
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

        iRepository.addFollowed(buyer,seller);
        iRepository.addFollower(buyer,seller);

        verify(iRepository,times(1)).addFollower(buyer,seller);
        verify(iRepository,times(1)).addFollowed(buyer,seller);
    }
/*
    @Test
    @DisplayName("T-0001 // Add follow, seller doesn't exist")
    public void addFollowSellerDoesntExist(){
        Buyer buyer = new Buyer(1, "Buyer1");

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(buyer.getUser_id(), null));
    }

    @Test
    @DisplayName("T-0001 // Add follow, buyer doesn't exist")
    public void addFollowBuyerDoesntExist(){
        Seller seller = new Seller(10, "Seller10");

        Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, seller.getUser_id()));
    }

 */
    @Test
    @DisplayName("T-0001 // Add follow, buyer, seller or both don't exist")
    public void addFollowBuyerAndSellerDontExist(){
        Buyer buyer = new Buyer(1, "Buyer1");
        Seller seller = new Seller(10, "Seller10");

        Assertions.assertAll(
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(buyer.getUser_id(), null)),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, seller.getUser_id())),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, null))
        );
    }

    @Test
    @DisplayName("T-0002 // Unfollow, OK")
    public void unFollowOk(){
        Seller seller = new Seller(10,"Seller10");
        Buyer buyer = new Buyer(1,"Buyer1");

        iRepository.unfollow(buyer,seller);

        verify(iRepository,times(1)).unfollow(buyer,seller);
    }

    @Test
    @DisplayName("T-0002 // Unfollow, not found")
    public void unFollowDontExist() {
        Buyer buyer = new Buyer(1, "Buyer1");
        Seller seller = new Seller(10, "Seller10");

        Assertions.assertAll(
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(buyer.getUser_id(), null)),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(null, seller.getUser_id())),
                () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(null, null))
        );
    }

    @Test
    @DisplayName("T-0003 // Verify asc or desc order")
    public void orderOk(){
        Seller seller = new Seller(10, "Seller20");
        String order = "name_desc";

        List<BuyerDTOResponse> expectedList = new ArrayList<>();
        expectedList.add(new BuyerDTOResponse(1, "1"));
        expectedList.add(new BuyerDTOResponse(2, "2"));
        expectedList.add(new BuyerDTOResponse(3, "3"));

        SellerFollowersListDTOResponse expected = new SellerFollowersListDTOResponse(seller.getUser_id(), seller.getName(), expectedList);

        // ----------------------------------------

        List<BuyerDTOResponse> responseList = new ArrayList<>();
        expectedList.add(new BuyerDTOResponse(1, "1"));
        expectedList.add(new BuyerDTOResponse(2, "2"));
        expectedList.add(new BuyerDTOResponse(3, "3"));

        SellerFollowersListDTOResponse response = new SellerFollowersListDTOResponse(seller.getUser_id(), seller.getName(), responseList);


        // --------------------------------------------

        when(serviceImp.getFollowersZA(seller.getUser_id())).thenReturn(response);


        SellerFollowersListDTOResponse responte1 = serviceImp.getFollowers(seller.getUser_id());
        Assertions.assertEquals(responte1, expected);
    }
}
