package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.NotFoundException;
import com.dh.be_java_hisp_w18_g10.exception.UserGenericException;
import com.dh.be_java_hisp_w18_g10.exception.UserNotFoundException;
import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.repository.IPostRepository;
import com.dh.be_java_hisp_w18_g10.repository.IUserRepository;
import com.dh.be_java_hisp_w18_g10.util.UserGenerator;
import com.dh.be_java_hisp_w18_g10.repository.PostRepository;
import com.dh.be_java_hisp_w18_g10.repository.UserRepository;
import com.dh.be_java_hisp_w18_g10.util.DateHandler;
import com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper;
import com.dh.be_java_hisp_w18_g10.util.UserGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper.NAME_DESC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static com.dh.be_java_hisp_w18_g10.util.TypeOrderHelper.NAME_ASC;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.activation.DataHandler;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.dh.be_java_hisp_w18_g10.util.UserGenerator.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
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
    @DisplayName("T0004- NAME_ASC")
    void shouldVerifyAlphabeticOrderAscOfFollowedTest() {
        //ARRANGE
        User user = UserGenerator.getUserFollowedName();
        UserFollowedListDTOres userFollowedOrderNameAsc = UserGenerator.getUserFollowedListDTOresOrderNameAsc();
        when(userRepository.getUser(userFollowedOrderNameAsc.getUser_id())).thenReturn(user);

        //ACTION
        UserFollowedListDTOres userFollowedResult = service.getUserFollowed(userFollowedOrderNameAsc.getUser_id(), NAME_ASC);

        //ASSERT
        List<UserDTOres> listUserFollowedOrderNameAsc = userFollowedOrderNameAsc.getFollowed();
        List<UserDTOres> listuserFollowedResult = userFollowedResult.getFollowed();

        for (int i = 0; i < listUserFollowedOrderNameAsc.size(); i++) {
            assertEquals(listUserFollowedOrderNameAsc.get(i).getUser_name(), listuserFollowedResult.get(i).getUser_name());
        }
        verify(userRepository, atLeastOnce()).getUser(userFollowedOrderNameAsc.getUser_id());

        //prueba de falla
        /*
         * UserFollowedListDTOres userFollowedDesordenado = UserGenerator.getUsersDesordenado();
         * int id = userFollowedDesordenado.getUser_id();
         * List<UserDTOres> listUserFollowedOrderNameAsc = userFollowedDesordenado.getFollowed();
         * */
    }
    @Test
    @DisplayName("T0004- NAME_DESC")
    void shouldVerifyAlphabeticOrderDesOfFollowedTest() {
        //ARRANGE
        User user = UserGenerator.getUserFollowedName();
        UserFollowedListDTOres userFollowedOrderNameDes = UserGenerator.getUserFollowedListDTOresOrderNameDes();
        when(userRepository.getUser(userFollowedOrderNameDes.getUser_id())).thenReturn(user);

        //ACTION
        UserFollowedListDTOres userFollowedResult = service.getUserFollowed(userFollowedOrderNameDes.getUser_id(), NAME_DESC);

        //ASSERT
        List<UserDTOres> listUserFollowedOrderNameDesc = userFollowedOrderNameDes.getFollowed();
        List<UserDTOres> listuserFollowedResult = userFollowedResult.getFollowed();

        for (int i = 0; i < listUserFollowedOrderNameDesc.size(); i++) {
            assertEquals(listUserFollowedOrderNameDesc.get(i).getUser_name(), listuserFollowedResult.get(i).getUser_name());
        }
        verify(userRepository, atLeastOnce()).getUser(userFollowedOrderNameDes.getUser_id());

        //prueba de falla
        /*
         * UserFollowedListDTOres userFollowedDesordenado = UserGenerator.getUsersDesordenado();
         * int id = userFollowedDesordenado.getUser_id();
         * List<UserDTOres> listUserFollowedOrderNameAsc = userFollowedDesordenado.getFollowed();
         * */
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
    @DisplayName("T0006 - Usuario no encontrado")
    void shouldVerifyDateSortButUserIsNullTest(){

        when(userRepository.getUser(8)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> service.getUserPosts(8,""));
    }

    @Test
    @DisplayName("T0007")
    void shouldVerifyAmountOfFollowersIsCorrectTest(){
        ///users/{userId}/followers/count
        UserFollowersCountDTOres expected = new UserFollowersCountDTOres(1,"usuario1",2);
        loadUsers();
        User user = getUser(1);
        when(userRepository.getUser(1)).thenReturn(user);

        UserFollowersCountDTOres result = service.getUserFollowersCount(1);

        assertEquals(expected,result);
    }
    @Test
    @DisplayName("T0007 - Usuario no encontrado")
    void shouldVerifyAmountOfFollowersUserNotFoundTest() throws Exception{

        when(userRepository.getUser(100)).thenReturn(null);

        assertThrows(NotFoundException.class, ()-> service.getUserFollowersCount(100));
    }

    @Test
    @DisplayName("T0008")
    void shouldVerifyDateOfPublishedPostIsLastTwoWeekTest(){
        LocalDate today = LocalDate.now();
        LocalDate tenDaysAgo = today.minusDays(10);
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        LocalDate twentyDaysAgo = today.minusDays(20);

        User user = new User(1, "daniel");
        User seller = new User(2, "alberto");

        Post todayPost = new Post(1, 1, today, new Product(), 1, 50);
        Post tenDaysAgoPost = new Post(1, 2, tenDaysAgo, new Product(), 1, 80);
        Post twentyDaysAgoPost = new Post(1, 3,  twentyDaysAgo, new Product(), 2, 100);
        Map<Integer, Post> posts = new HashMap<Integer, Post>();
        posts.put(1, twentyDaysAgoPost);
        posts.put(2, tenDaysAgoPost);
        posts.put(3, todayPost);
        user.getFollowed().put(2, seller);
        seller.setPosts(posts);

        when(userRepository.getUser(1)).thenReturn(user);
        when(userRepository.getUser(2)).thenReturn(seller);

        UserPostsDTOres userPostsDto = service.getUserPosts(1, null);
        assertEquals(userPostsDto.getPosts().size(), 2);
        userPostsDto.getPosts().forEach(
                p -> {
                    assertThat(DateHandler.StringToDate(p.getDate()).isAfter(twoWeeksAgo)).isTrue();
                }
        );

    }


}
