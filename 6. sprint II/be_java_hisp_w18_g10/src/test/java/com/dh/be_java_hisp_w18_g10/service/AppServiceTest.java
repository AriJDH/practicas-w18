package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.repository.IPostRepository;
import com.dh.be_java_hisp_w18_g10.repository.IUserRepository;
import com.dh.be_java_hisp_w18_g10.repository.PostRepository;
import com.dh.be_java_hisp_w18_g10.repository.UserRepository;
import com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper;
import com.dh.be_java_hisp_w18_g10.util.UserGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.dh.be_java_hisp_w18_g10.util.UserGenerator.*;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Autowired
    public UserGenerator userGenerator;
    @Mock
    public PostRepository postRepository;

    @Mock
    public UserRepository userRepository;

    @InjectMocks
    AppService service;


    @Test
    @DisplayName("T0001")
    void shouldFollowASellerTest(){
    }

    @Test
    @DisplayName("T0002")
    void shouldDisplayAmountOfFollowerASellerHaveTest(){
    }

    @Test
    @DisplayName("T0003")
    void shouldDisplayAllFollowersASellerHaveTest(){
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
    @DisplayName("T0006 - Ascendente")
    void shouldVerifyDateSortAscTest(){
        //Arrange
        UserPostsDTOres expected = getUserPostsDTOresOrderByDateAsc();
        loadUsers();
        User user = getUser(1);
        User vendedor1 = getUser(2);
        User vendedor2 = getUser(3);

        when(userRepository.getUser(1)).thenReturn(user);
        when(userRepository.getUser(2)).thenReturn(vendedor1);
        when(userRepository.getUser(3)).thenReturn(vendedor2);

        UserPostsDTOres result = service.getUserPosts(1, "");

        assertArrayEquals(expected.getPosts().toArray(),result.getPosts().toArray());
    }
    @Test
    @DisplayName("T0006 - Descendente")
    void shouldVerifyDateSortDescTest(){
        //Arrange
        UserPostsDTOres expected = getUserPostsDTOresOrderByDateDesc();
        loadUsers();
        User user = getUser(1);
        User vendedor1 = getUser(2);
        User vendedor2 = getUser(3);

        when(userRepository.getUser(1)).thenReturn(user);
        when(userRepository.getUser(2)).thenReturn(vendedor1);
        when(userRepository.getUser(3)).thenReturn(vendedor2);

        UserPostsDTOres result = service.getUserPosts(1, TypeOrderHelper.DATE_DESC);

        assertArrayEquals(expected.getPosts().toArray(),result.getPosts().toArray());
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
