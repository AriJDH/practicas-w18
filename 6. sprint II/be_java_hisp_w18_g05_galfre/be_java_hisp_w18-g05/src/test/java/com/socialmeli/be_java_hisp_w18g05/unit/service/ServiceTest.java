package com.socialmeli.be_java_hisp_w18g05.unit.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidParameterException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import com.socialmeli.be_java_hisp_w18g05.service.ServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

import static com.socialmeli.be_java_hisp_w18g05.utils.UtilsTest.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    IRepository iRepository;
    @InjectMocks
    ServiceImp serviceImp;

    @Nested
    @DisplayName("T-0001")
    class T0001 {
        @Test
        @DisplayName("OK - Verificar que el usuario a seguir exista. (US-0001)")
        public void addFollowOk() {
            //========= Arrange ============
            Seller seller = getSeller10();
            Buyer buyer = getBuyer1();
            iRepository.addFollowed(buyer, seller);
            iRepository.addFollower(buyer, seller);
            //========= Act & Asserts ======
            verify(iRepository, times(1)).addFollower(buyer, seller);
            verify(iRepository, times(1)).addFollowed(buyer, seller);
        }

        @Test
        @DisplayName("NO OK - Verificar que el usuario a seguir exista. (US-0001)")
        public void addFollowBuyerAndSellerDontExist() {
            //========= Arrange ============
            Seller seller = getSeller10();
            Buyer buyer = getBuyer1();
            //========= Act & Asserts ======
            Assertions.assertAll(
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(buyer.getUser_id(), null)),
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, seller.getUser_id())),
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.follow(null, null))
            );
        }
    }
    @Nested
    @DisplayName("T-0002")
    class T0002 {
        @Test
        @DisplayName("OK - Verificar que el usuario a dejar de seguir exista. (US-0007)")
        public void unFollowOk() {
            //========= Arrange ============
            Seller seller = getSeller10();
            Buyer buyer = getBuyer1();
            iRepository.unfollow(buyer, seller);
            //========= Act & Asserts ======
            verify(iRepository, times(1)).unfollow(buyer, seller);
        }

        @Test
        @DisplayName("NO OK - Verificar que el usuario a dejar de seguir exista. (US-0007)")
        public void unFollowDontExist() {
            //========= Arrange ============
            Seller seller = getSeller10();
            Buyer buyer = getBuyer1();
            //========= Act & Asserts ======
            Assertions.assertAll(
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(buyer.getUser_id(), null)),
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(null, seller.getUser_id())),
                    () -> Assertions.assertThrows(NotFoundException.class, () -> serviceImp.unfollow(null, null))
            );
        }
    }
    @Nested
    @DisplayName("T-0003")
    class T0003 {
        @Test
        @DisplayName("OK - Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
        void test0003Ok() {
            //========= Arrange ==========
            Integer userId = 1;
            String order = "name_desc";
            Buyer buyerMock = getBuyerWithListOrderDesc(userId);
            //========= Mock =============
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ==============
            serviceImp.followedsFilter(userId, order).getFollowed();
            //========= Asserts ==========
            verify(iRepository, atLeastOnce()).getByIdBuyer(userId);
        }

        @Test
        @DisplayName("NO OK - Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
        void test0003NotOk() {
            //========= Arrange ==========
            Integer userId = 1;
            String order = "not_valid";
            //========= Act Asserts ======
            Assertions.assertThrows(InvalidParameterException.class, () -> serviceImp.followedsFilter(userId, order));
        }
    }

    @Nested
    @DisplayName("T-0004")
    class T0004 {
        @Test
        @DisplayName("Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0003)")
        void test0004Asc0803() {
            //========= Arrange ============
            Integer userId = 1;
            String order = "name_asc";
            Seller sellerMock = getSellerWithListOrderAsc(userId); // utils static method
            List<Buyer> expected = sellerMock.getFollowers();
            //========= Mock ===============
            when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
            //========= Act  ===============
            List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
            //========= Asserts ============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                    () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                    () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
            );
        }

        @Test
        @DisplayName("Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0003)")
        void test0004Desc0803() {
            //========= Arrange ============
            Integer userId = 1;
            String order = "name_desc";
            Seller sellerMock = getSellerWithListOrderDesc(userId); // utils static method
            List<Buyer> expected = sellerMock.getFollowers();
            //========= Mock ===============
            when(iRepository.getByIdSeller(userId)).thenReturn(sellerMock);
            //========= Act  ===============
            List<BuyerDTOResponse> result = serviceImp.followersFilter(userId, order).getFollowers();
            //========= Asserts ============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                    () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                    () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
            );
        }

        @Test
        @DisplayName("Verificar el correcto ordenamiento ascendente por nombre. (US-0008 - US-0004)")
        void test0004Asc0804() {
            //========= Arrange ============
            Integer userId = 1;
            String order = "name_asc";
            Buyer buyerMock = getBuyerWithListOrderAsc(userId); // utils static method
            List<Seller> expected = buyerMock.getFolloweds();
            //========= Mock ===============
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ================
            List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
            //========= Asserts ============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                    () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                    () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
            );
        }

        @Test
        @DisplayName("Verificar el correcto ordenamiento descendente por nombre. (US-0008 - US-0004)")
        void test0004Desc0804() {
            //========= Arrange ============
            Integer userId = 1;
            String order = "name_desc";
            Buyer buyerMock = getBuyerWithListOrderDesc(userId); // utils static method
            List<Seller> expected = buyerMock.getFolloweds();
            //========= Mock ===============
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ================
            List<SellerDTOResponse> result = serviceImp.followedsFilter(userId, order).getFollowed();
            //========= Asserts ============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.get(0).getUser_id(), expected.get(0).getUser_id()),
                    () -> Assertions.assertEquals(result.get(1).getUser_id(), expected.get(1).getUser_id()),
                    () -> Assertions.assertEquals(result.get(2).getUser_id(), expected.get(2).getUser_id())
            );
        }
    }


    @Nested
    @DisplayName("T-0005")
    class T0005 {
        @Test
        @DisplayName("OK - Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
        void test0005Ok() {
            //========= Arrange ==========
            Integer userId = 1;
            String order = "date_desc";
            // Creamos comprador con la lista de sellers que sigue
            Buyer buyerMock = getBuyerWith2SellerWith5Post(userId);
            //========= Mock =============
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ==============
            serviceImp.followedPostList(userId, order);
            //========= Asserts ==========
            verify(iRepository, atLeastOnce()).getByIdBuyer(userId);
        }

        @Test
        @DisplayName("NO OK - Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
        void test0005NotOk() {
            //========= Arrange ==========
            String order = "not_valid";
            int userId = 1;
            Buyer buyerMock = getBuyerWith2Sellers(userId);
            //========= Mock =============
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act & Asserts ====
            Assertions.assertThrows(InvalidException.class, () -> serviceImp.followedPostList(userId, order));
        }
    }

    @Nested
    @DisplayName("T-0006")
    class T0006 {
        @Test
        @DisplayName("Verificar el correcto ordenamiento por fecha ascendente. (US-0009)")
        void test0006Asc() {
            //========= Arrange =============
            Integer userId = 1;
            String order = "date_asc";
            // Creamos comprador con la lista de sellers que sigue
            Buyer buyerMock = getBuyerWith2SellerWith5Post(userId);
            // Creamos el expected con los post como deberían estar ordenados.
            SellerPostListDTOResponse expected = getSellerPostListDTOResponseAsc(userId);
            //========= Mock =================
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ==================
            SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
            //========= Asserts ==============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
            );
        }

        @Test
        @DisplayName("Verificar el correcto ordenamiento por fecha descendente. (US-0009)")
        void test0006Desc() {
            //========= Arrange =============
            Integer userId = 1;
            String order = "date_desc";
            // Creamos comprador con la lista de sellers que sigue
            Buyer buyerMock = getBuyerWith2SellerWith5Post(userId);
            // Creamos el expected con los post como deberían estar ordenados.
            SellerPostListDTOResponse expected = getSellerPostListDTOResponseDesc(userId);
            //========= Mock =================
            when(iRepository.getByIdBuyer(userId)).thenReturn(buyerMock);
            //========= Act ==================
            SellerPostListDTOResponse result = serviceImp.followedPostList(userId, order);
            //========= Asserts ==============
            Assertions.assertAll(
                    () -> Assertions.assertEquals(result.getPosts().get(0).getPost_id(), expected.getPosts().get(0).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(1).getPost_id(), expected.getPosts().get(1).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(2).getPost_id(), expected.getPosts().get(2).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(3).getPost_id(), expected.getPosts().get(3).getPost_id()),
                    () -> Assertions.assertEquals(result.getPosts().get(4).getPost_id(), expected.getPosts().get(4).getPost_id())
            );
        }
    }

    @Nested
    @DisplayName("T-0007")
    class T0007 {
        @Test
        @DisplayName("OK - Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)")
        public void followersCountTest() {
            //========= Arrange ==============
            int userId = 10;
            Seller seller = getSellerWith2Buyer(userId);
            SellerFollowersCountDTOResponse expected = getSellerDTOWith2Buyers(userId);
            //========= Mock =================
            when(iRepository.getByIdSeller(seller.getUser_id())).thenReturn(seller);
            //========= Act ==================
            SellerFollowersCountDTOResponse result = serviceImp.followersCount(seller.getUser_id());
            //========= Asserts ==============
            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("NO OK - Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)")
        public void followersCountTestNotExist() {
            //========= Mock ================
            when(iRepository.getByIdSeller(1)).thenReturn(null);
            //========= Act & Asserts =======
            Assertions.assertThrows(NotFoundException.class, () -> serviceImp.followersCount(1));
        }
    }

    @Nested
    @DisplayName("T-0008")
    class T0008 {
        @Test
        @DisplayName("Verificar que la consulta de publicaciones sea correcta  (US-0006)")
        public void postTwoWeeks() {
            //========= Arrange ==============
            Integer userId = 1;
            Buyer buyer = getBuyerWith2SellerWith3Post(userId);
            SellerPostListDTOResponse expected = getSellerPostListDTOResponse(userId);
            //========= Mock =============
            when(iRepository.getByIdBuyer(1)).thenReturn(buyer);
            //========= Act ==============
            SellerPostListDTOResponse result = serviceImp.orderByDate(buyer.getUser_id(), "date_desc");
            //========= Asserts ==========
            Assertions.assertEquals(expected, result);
        }
    }

}

