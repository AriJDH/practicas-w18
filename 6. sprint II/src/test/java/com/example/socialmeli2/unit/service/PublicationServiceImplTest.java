package com.example.socialmeli2.unit.service;

import com.example.socialmeli2.dto.response.PublicationResponse;
import com.example.socialmeli2.dto.response.UserFollowedPublicationResponse;
import com.example.socialmeli2.entity.PublicationEntity;
import com.example.socialmeli2.entity.UserEntity;
import com.example.socialmeli2.exception.InvalidParameterException;
import com.example.socialmeli2.repository.IPublicationRepository;
import com.example.socialmeli2.repository.IUserRepository;
import com.example.socialmeli2.service.PublicationServiceImpl;
import com.example.socialmeli2.util.ListSorterByOrder;
import com.example.socialmeli2.util.PublicationFactory;
import com.example.socialmeli2.util.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PublicationServiceImplTest {

    @Mock
    IPublicationRepository publicationRepository;
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    PublicationServiceImpl publicationService;

    @Nested
    @DisplayName("T-0005 - Verificar que el tipo de ordenamiento por fecha exista")
    class getUserFollowedPublicationsById {

        @Test
        @DisplayName("Success - Valid Order")
        void test1() {

            //Arrange
            String orderValid = "date_desc";
            List<PublicationResponse> publications = PublicationFactory.createListOfPublicationsOrderAsc();

            //Act & Assert
            Assertions.assertDoesNotThrow(() -> ListSorterByOrder.publicationSortedByDate(publications, orderValid));

        }

        @Test
        @DisplayName("Exception - Invalid Order")
        void test2() {

            //Arrange
            String orderInvalid = "invalidOrder";
            List<PublicationResponse> publications = PublicationFactory.createListOfPublicationsOrderAsc();

            //Act & Assert
            Assertions.assertThrows(InvalidParameterException.class, () -> ListSorterByOrder.publicationSortedByDate(publications, orderInvalid));
        }

        @Test
        @DisplayName("Success - Default Order")
        void test3() {

            //Arrange
            String orderDefault = "";
            List<PublicationResponse> publications = PublicationFactory.createListOfPublicationsOrderDesc();

            //Act & Assert
            Assertions.assertDoesNotThrow(() -> ListSorterByOrder.publicationSortedByDate(publications, orderDefault));

        }
    }

    @Nested
    @DisplayName("T-0006 - Verify correct ascending and descending ordering by date")
    class getListOfPublicationsFollowed {

        @Test
        @DisplayName("Success - Order ASC by date in a sorted list")
        void test1() {

            //Arrange
            Integer userId = 1;

            UserEntity userReturn = UserFactory.getUserWithFolloweds(userId, "Carlos");
            UserEntity seller = UserFactory.getUserWithFollowersAndPublicationsAsc(userId, "Felipe");
            List<Integer> followedList = userReturn.getFollowedList();
            PublicationEntity publication1 = PublicationFactory.getPublicationsReturn().get(0);
            PublicationEntity publication2 = PublicationFactory.getPublicationsReturn().get(1);

            //Expected
            List<PublicationResponse> listPublications = PublicationFactory.createListOfPublicationsOrderAsc();
            UserFollowedPublicationResponse expected = new UserFollowedPublicationResponse(userId, listPublications);

            //Mock
            when(userRepository.getEntityById(userId)).thenReturn(userReturn);
            when(userRepository.getEntityById(followedList.get(0))).thenReturn(seller);
            //Mockeo los items de forma ascendente
            when(publicationRepository.getEntityById(1)).thenReturn(publication1); //fecha 15/11/2022
            when(publicationRepository.getEntityById(2)).thenReturn(publication2); //fecha 16/11/2022

            //Act
            UserFollowedPublicationResponse result = publicationService.getUserFollowedPublicationsById(userId, "date_asc");

            //Assert
            assertEquals(expected, result);

        }

        @Test
        @DisplayName("Success - Order DESC by date in a sorted list")
        void test2(){

            //Arrange
            Integer userId = 1;

            //Result
            UserEntity userReturn = UserFactory.getUserWithFolloweds(userId, "Carlos");
            UserEntity seller = UserFactory.getUserWithFollowersAndPublicationsDesc(2, "Felipe");
            List<Integer> followedList = userReturn.getFollowedList();
            PublicationEntity publication1 = PublicationFactory.getPublicationsReturn().get(0);
            PublicationEntity publication2 = PublicationFactory.getPublicationsReturn().get(1);

            //Expected
            List<PublicationResponse> listPublications = PublicationFactory.createListOfPublicationsOrderDesc();
            UserFollowedPublicationResponse expected = new UserFollowedPublicationResponse(userId, listPublications);

            //Mock
            when(userRepository.getEntityById(userId)).thenReturn(userReturn);
            when(userRepository.getEntityById(followedList.get(0))).thenReturn(seller);
            //Mockeo los items de forma descendente
            when(publicationRepository.getEntityById(2)).thenReturn(publication2); //fecha 16/11/2022
            when(publicationRepository.getEntityById(1)).thenReturn(publication1); //fecha 15/11/2022

            //Act
            UserFollowedPublicationResponse result = publicationService.getUserFollowedPublicationsById(userId, "date_desc");

            //Assert
            assertEquals(expected, result);

        }

        @Test
        @DisplayName("Success - Order ASC by date in a unsorted list")
        void test3() {

            //Arrange
            Integer userId = 1;

            UserEntity userReturn = UserFactory.getUserWithFolloweds(userId, "Carlos");
            UserEntity seller = UserFactory.getUserWithFollowersAndPublicationsAsc(2, "Felipe");
            List<Integer> followedList = userReturn.getFollowedList();
            PublicationEntity publication1 = PublicationFactory.getPublicationsReturn().get(0);
            PublicationEntity publication2 = PublicationFactory.getPublicationsReturn().get(1);

            //Expected
            List<PublicationResponse> listPublications = PublicationFactory.createListOfPublicationsOrderAsc();
            UserFollowedPublicationResponse expected = new UserFollowedPublicationResponse(userId, listPublications);

            //Mock
            when(userRepository.getEntityById(userId)).thenReturn(userReturn);
            when(userRepository.getEntityById(followedList.get(0))).thenReturn(seller);
            //Invierto el orden en que se mockean las publicaciones enviando primero la publicacion mas reciente
            //para validar el correcto ordenamiento ascendente
            when(publicationRepository.getEntityById(2)).thenReturn(publication2);
            when(publicationRepository.getEntityById(1)).thenReturn(publication1);

            //Act
            UserFollowedPublicationResponse result = publicationService.getUserFollowedPublicationsById(userId, "date_asc");

            //Assert
            assertEquals(expected, result);

        }

        @Test
        @DisplayName("Success - Order DESC by date in a unsorted list")
        void test4() {

            //Arrange
            Integer userId = 1;

            //Result
            UserEntity userReturn = UserFactory.getUserWithFolloweds(userId, "Carlos");
            UserEntity seller = UserFactory.getUserWithFollowersAndPublicationsDesc(2, "Felipe");
            List<Integer> followedList = userReturn.getFollowedList();
            PublicationEntity publication1 = PublicationFactory.getPublicationsReturn().get(0);
            PublicationEntity publication2 = PublicationFactory.getPublicationsReturn().get(1);

            //Expected
            List<PublicationResponse> listPublications = PublicationFactory.createListOfPublicationsOrderDesc();
            UserFollowedPublicationResponse expected = new UserFollowedPublicationResponse(userId, listPublications);

            //Mock
            when(userRepository.getEntityById(userId)).thenReturn(userReturn);
            when(userRepository.getEntityById(followedList.get(0))).thenReturn(seller);
            //Mockeo las publicaciones ordenando las fechas de publicacion en orden ascendente
            //para validar que se ordenen descendentemente
            when(publicationRepository.getEntityById(1)).thenReturn(publication1);
            when(publicationRepository.getEntityById(2)).thenReturn(publication2);

            //Act
            UserFollowedPublicationResponse result = publicationService.getUserFollowedPublicationsById(userId, "date_desc");

            //Assert
            assertEquals(expected, result);

        }
    }

    /**
     * T-0008 - Verify that the consultation of publications a certain seller
     * are from the last two weeks. (US-0006)
     */
    @Nested
    @DisplayName("T-0008 - Verify that seller publications are from the last two weeks")
    class getUserFollowedPublicationsByIdTwoWeeks {

        @Test
        @DisplayName("Success - Seller publications are from the last two weeks")
        void test1() {

            //Arrange
            Integer userId = 1;

            //Result
            UserEntity userReturn = UserFactory.getUserWithFolloweds(userId, "Carlos");
            UserEntity seller = UserFactory.getUserWithFollowersAndPublicationsRandomDate(2, "Felipe");
            List<Integer> followedList = userReturn.getFollowedList();
            List<PublicationEntity> publicationsRandomDate = PublicationFactory.getPublicationsInLastFourWeeks();

            //Expected
            List<PublicationResponse> publicationResponseList = PublicationFactory.getPublicationsInLastTwoWeeks();
            UserFollowedPublicationResponse expected = new UserFollowedPublicationResponse(userId, publicationResponseList);

            //Mock
            when(userRepository.getEntityById(userId)).thenReturn(userReturn);
            when(userRepository.getEntityById(followedList.get(0))).thenReturn(seller);
            //Mockeo las publicaciones con fechas dentro y fuera de dos semanas
            for (PublicationEntity publicationRandomDate : publicationsRandomDate) {
                when(publicationRepository.getEntityById(publicationRandomDate.getId())).thenReturn(publicationRandomDate);
            }

            //Act
            UserFollowedPublicationResponse result = publicationService.getUserFollowedPublicationsById(userId, "");

            //Assert
            assertEquals(expected, result);

        }

    }

}
