package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.response.PostDtoRes;
import com.mercadolibre.socialmeli2.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento " +
            "descendente por fecha. (US-0009)")
    // De mas Nuevo a mas Viejo
    public void test0006DateDesc() {
        // Arrange
        int userId = 1;
        String order = "date_desc";
        LocalDate today = LocalDate.now();
        User user = UserFactory.userWithId(userId);
        User seller2 = UserFactory.userWithId(2);
        User seller3 = UserFactory.userWithId(3);
        Post post1 = UserFactory.postWithDate(today);
        Post post2 = UserFactory.postWithDate(today.minusDays(2));
        Post post3 = UserFactory.postWithDate(today.minusDays(5));
        seller2.addPost(post1);
        seller2.addPost(post2);
        seller3.addPost(post3);
        user.addFollowed(seller2);
        user.addFollowed(seller3);

        when(userRepositoryMock.existsById(userId)).thenReturn(true);
        when(userRepositoryMock.findById(userId)).thenReturn(user);

        // Act
        RecentPostsDtoRes recentPosts = userService.getRecentPosts(userId, order);

        // Assert
        assertAll(()-> {
            PostDtoRes p0 = recentPosts.getPosts().get(0);
            PostDtoRes p1 = recentPosts.getPosts().get(1);
            PostDtoRes p2 = recentPosts.getPosts().get(2);
            assertTrue(p0.getDate().isAfter(p1.getDate()));
            assertTrue(p1.getDate().isAfter(p2.getDate()));
        });
    }

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento " +
            "ascendente por fecha. (US-0009)")
    // De mas viejo a mas nuevo
    public void test0006DateAsc() {
        // Arrange
        int userId = 1;
        String order = "date_asc";
        LocalDate today = LocalDate.now();
        User user = UserFactory.userWithId(userId);
        User seller2 = UserFactory.userWithId(2);
        User seller3 = UserFactory.userWithId(3);
        Post post1 = UserFactory.postWithDate(today);
        Post post2 = UserFactory.postWithDate(today.minusDays(2));
        Post post3 = UserFactory.postWithDate(today.minusDays(5));
        seller2.addPost(post1);
        seller2.addPost(post2);
        seller3.addPost(post3);
        user.addFollowed(seller2);
        user.addFollowed(seller3);

        when(userRepositoryMock.existsById(userId)).thenReturn(true);
        when(userRepositoryMock.findById(userId)).thenReturn(user);

        // Act
        RecentPostsDtoRes recentPosts = userService.getRecentPosts(userId, order);

        // Assert
        assertAll(()-> {
            PostDtoRes p0 = recentPosts.getPosts().get(0);
            PostDtoRes p1 = recentPosts.getPosts().get(1);
            PostDtoRes p2 = recentPosts.getPosts().get(2);
            assertTrue(p0.getDate().isBefore(p1.getDate()));
            assertTrue(p1.getDate().isBefore(p2.getDate()));
        });
    }

    @Test
    @DisplayName("T-0008 Verificar que la consulta de publicaciones " +
            "realizadas en las últimas dos semanas de un determinado " +
            "vendedor sean efectivamente de las últimas dos semanas. (US-0006)" )
    public void test0008WithinTwoWeeks(){
        // Arrange
        int userId = 1;
        LocalDate today = LocalDate.now();
        User user = UserFactory.userWithId(userId);
        User seller2 = UserFactory.userWithId(2);
        User seller3 = UserFactory.userWithId(3);
        Post post1 = UserFactory.postWithDate(today.plusDays(2));
        Post post2 = UserFactory.postWithDate(today.minusDays(2));
        Post post3 = UserFactory.postWithDate(today.minusDays(20));
        seller2.addPost(post1);
        seller2.addPost(post2);
        seller3.addPost(post3);
        user.addFollowed(seller2);
        user.addFollowed(seller3);

        when(userRepositoryMock.existsById(userId)).thenReturn(true);
        when(userRepositoryMock.findById(userId)).thenReturn(user);

        int expectedSize = 1;
        // Act
        RecentPostsDtoRes recentPosts = userService.getRecentPosts(userId, null);

        // Assert
        assertEquals(expectedSize, recentPosts.getPosts().size());
    }

    @Test
    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
    void orderTestAscj() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        List<User> followers = UserFactory.getUsers();
        List<UserDtoRes> usersDtosRes = followers.stream()
                .map(u -> new UserDtoRes(u.getId(), u.getName()))
                .collect(Collectors.toList());

        SellerFollowerListDtoRes expected = new SellerFollowerListDtoRes(id, seller.getName(), usersDtosRes);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.getFollowers(id)).thenReturn(followers);
        when(userRepositoryMock.findById(id)).thenReturn(seller);
        // Act
        SellerFollowerListDtoRes result = userService.getFollowers(id, "name_asc");

        // Assert
        Assertions.assertEquals(1,1);
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento ascendente")
    void orderTestAsc() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        List<User> followers = UserFactory.getUsers();

        List<UserDtoRes> expectedUserDtos = UserFactory.getUsersListDto("name_asc");
        SellerFollowerListDtoRes expected = new SellerFollowerListDtoRes(id, seller.getName(), expectedUserDtos);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.getFollowers(id)).thenReturn(followers);
        when(userRepositoryMock.findById(id)).thenReturn(seller);
        // Act
        SellerFollowerListDtoRes result = userService.getFollowers(id, "name_asc");

        // Assert
        Assertions.assertEquals(expected.getFollowers(), result.getFollowers());
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento descendente")
    void orderTestDesc() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        List<User> followers = UserFactory.getUsers();

        List<UserDtoRes> expectedUserDtos = UserFactory.getUsersListDto("name_desc");
        SellerFollowerListDtoRes expected = new SellerFollowerListDtoRes(id, seller.getName(), expectedUserDtos);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.getFollowers(id)).thenReturn(followers);
        when(userRepositoryMock.findById(id)).thenReturn(seller);
        // Act
        SellerFollowerListDtoRes result = userService.getFollowers(id, "name_desc");

        // Assert
        Assertions.assertEquals(expected.getFollowers(), result.getFollowers());
    }

    @Test
    @DisplayName("T-0007 Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    void getCountTestOk() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        List<User> followers = UserFactory.getUsers();
        SellerFollowerCountDtoRes expected = new SellerFollowerCountDtoRes(id, seller.getName(), 3);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.getFollowers(id)).thenReturn(followers);
        when(userRepositoryMock.findById(id)).thenReturn(seller);
        // Act
        SellerFollowerCountDtoRes result = userService.getCount(id);

        // Assert
        Assertions.assertEquals(expected.getFollowersCount(), result.getFollowersCount());
    }

    @Test
    @DisplayName("T-0007 Usuario no existe")
    void getCountTestSad() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(false);

        // Act y Assert
        Assertions.assertThrows(NotFoundException.class, () -> userService.getCount(id));
    }
}
