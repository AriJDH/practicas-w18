package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.repository.IPostRepository;
import com.dh.be_java_hisp_w18_g10.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Mock
    public IPostRepository postRepository;

    @Mock
    public IUserRepository userRepository;

    @InjectMocks
    public IAppService service;


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
