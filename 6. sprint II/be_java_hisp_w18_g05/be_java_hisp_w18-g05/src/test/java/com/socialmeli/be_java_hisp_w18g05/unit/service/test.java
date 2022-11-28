package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
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


}
