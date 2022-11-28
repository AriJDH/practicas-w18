package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.UserGenericException;
import com.dh.be_java_hisp_w18_g10.repository.IPostRepository;
import com.dh.be_java_hisp_w18_g10.repository.IUserRepository;
import com.dh.be_java_hisp_w18_g10.repository.PostRepository;
import com.dh.be_java_hisp_w18_g10.repository.UserRepository;
import com.dh.be_java_hisp_w18_g10.util.UserGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Mock
    PostRepository postRepository;
    UserRepository userRepository = mock(UserRepository.class);

    AppService service = new AppService(userRepository, postRepository);

    @Test
    @DisplayName("T0001")
    void shouldFollowASellerTest(){
    }

    @Test
    @DisplayName("T0002")
    void shouldDisplayAmountOfFollowerASellerHaveTest(){
    }

    @Test
    @DisplayName("T0003 - OK")
    void shouldReturnOrderedFollowersList(){
        //Arrange
        int id = 1;
        String userName = "usuario1";
        String typeOrderAsc = "name_asc";
        String typeOrderDes = "name_desc";

        User followedUser = UserGenerator.getUserWithFollowers();

        UserFollowersListDTOres followersListDTOres = UserGenerator.UserFollowersDTOGenerator();

        //Mock
        when(userRepository.getUser(id)).thenReturn(followedUser);

        UserFollowersListDTOres result = service.getUserFollowerList(id, typeOrderDes);

        //Act
        Assertions.assertEquals(followersListDTOres.getFollowers(), result.getFollowers());

        //Assert
    }

    @Test
    @DisplayName("T0004")
    void shouldVerifyAlphabeticOrderOfFollowedTest(){
    }

    @Test
    @DisplayName("T0005")
    void shouldVerifyDateSortTest(){
    }

    @Test
    @DisplayName("T0006")
    void shouldVerifyDateSortAscToDescTest(){
    }

    @Test
    @DisplayName("T0007")
    void shouldVerifyAmountOfFollowersIsCorrectTest(){
    }

    @Test
    @DisplayName("T0008")
    void shouldVerifyDateOfPublishedPostIsLastTwoWeekTest(){
    }


}
