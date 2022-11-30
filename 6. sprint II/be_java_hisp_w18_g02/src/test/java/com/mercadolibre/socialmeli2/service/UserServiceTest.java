package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.response.*;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import com.mercadolibre.socialmeli2.exception.OrderInvalidException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista (US-0001). Caso de éxito.")
    void test0001FollowUserExists(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(2);
        Integer userTofollowId = Integer.valueOf(3);
        String excpectedResult = "El usuario " + userFollowerId + " ahora sigue al usuario " + userTofollowId;
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));
        when(userRepositoryMock.findById(userTofollowId)).thenReturn(users.get(userTofollowId));

        //Act
        String result = userService.follow(userFollowerId, userTofollowId);

        //Assert
        assertEquals(excpectedResult, result);
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista (US-0001). Caso de error (seguidor o seguido no existe.")
    void test0001UserNotExists(){
        //Arrange
        Integer userNotExists = Integer.valueOf(9999);
        Integer userExists = Integer.valueOf(2);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userExists)).thenReturn(users.get(userExists));
        when(userRepositoryMock.findById(userNotExists)).thenReturn(users.get(userNotExists));

        //Act and Assert
        assertAll(()->{
            assertThrows(NotFoundException.class ,()->userService.follow(userNotExists, userExists));
            assertThrows(NotFoundException.class ,()->userService.follow(userExists, userNotExists));
        });
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista (US-0001). Caso de error (usuario a seguir no es vendedor.")
    void test0001FollowUserNotSeller(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(2);
        Integer userTofollowId = Integer.valueOf(1);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));
        when(userRepositoryMock.findById(userTofollowId)).thenReturn(users.get(userTofollowId));

        //Act and Assert
        assertThrows(IllegalArgumentException.class ,()->userService.follow(userFollowerId, userTofollowId));
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista (US-0001). Caso de error (seguidor ya es seguido.")
    void test0001FollowUserAlreadyFollowed(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(1);
        Integer userTofollowId = Integer.valueOf(3);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));
        when(userRepositoryMock.findById(userTofollowId)).thenReturn(users.get(userTofollowId));

        //Act and Assert
        assertThrows(IllegalArgumentException.class ,()->userService.follow(userFollowerId, userTofollowId));
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista (US-0001). Caso de error (seguidor y seguido son el mismo usuario.")
    void test0001FollowSelfUser(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(1);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Act and Assert
        assertThrows(IllegalArgumentException.class ,()->userService.follow(userFollowerId, userFollowerId));
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista (US-0007). Caso de éxito.")
    void test0002UnfollowUserExists(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(1);
        Integer userToUnfollowId = Integer.valueOf(3);
        String excpectedResult = "El usuario " + userFollowerId + " dejó de seguir al usuario " + userToUnfollowId;
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));

        //Act
        String result = userService.unfollow(userFollowerId, userToUnfollowId);

        //Assert
        assertEquals(excpectedResult, result);
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista (US-0007). Caso de error (seguidor no existe.")
    void test0002UnfollowUserNotExists(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(9999);
        Integer userToUnfollowId = Integer.valueOf(3);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));

        //Act and Assert
        assertThrows(NotFoundException.class ,()->userService.unfollow(userFollowerId, userToUnfollowId));
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista (US-0007). Caso de error (Usuario a dejar de seguir no es seguido.")
    void test0002UnfollowUserNotFollowed(){
        //Arrange
        Integer userFollowerId = Integer.valueOf(2);
        Integer userToUnfollowId = Integer.valueOf(4);
        Map<Integer, User> users = UserFactory.loadUsers();

        //Mock
        when(userRepositoryMock.findById(userFollowerId)).thenReturn(users.get(userFollowerId));

        //Act and Assert
        assertThrows(NotFoundException.class ,()->userService.unfollow(userFollowerId, userToUnfollowId));
    }

    @Test
    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)")
    void orderTestExists() {
        // Arrange
        User user = new User(1, "Jose");
        Integer id = user.getId();

        List<User> followed = UserFactory.getUsers();
        user.setFollowed(new HashSet<>(followed));

        List<UserDtoRes> expectedUserDtos = UserFactory.getUsersListDto("name_asc");
        UserFollowedListDtoRes expected = new UserFollowedListDtoRes(id, user.getName(), expectedUserDtos);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.findById(id)).thenReturn(user);
        // Act
        UserFollowedListDtoRes result = userService.getFollowed(id, "name_asc");

        // Assert
        Assertions.assertEquals(expected.getFollowed(), result.getFollowed());
    }

    @Test
    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético sea nulo (US-0008)")
    void orderTestNull() {
        // Arrange
        User user = new User(1, "Jose");
        Integer id = user.getId();

        List<User> followed = UserFactory.getUsers();
        user.setFollowed(new HashSet<>(followed));

        List<UserDtoRes> expectedUserDtos = UserFactory.getUsersListDto("algo");
        UserFollowedListDtoRes expected = new UserFollowedListDtoRes(id, user.getName(), expectedUserDtos);

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.findById(id)).thenReturn(user);
        // Act
        UserFollowedListDtoRes result = userService.getFollowed(id, null);

        // Assert
        Assertions.assertEquals(expected.getId(), result.getId());
    }

    @Test
    @DisplayName("T-0003 Verificar que el tipo de ordenamiento alfabético no exista (US-0008)")
    void orderTestNotExists() {
        // Arrange
        User seller = new User(1, "Jose");
        Integer id = seller.getId();

        List<User> followers = UserFactory.getUsers();

        // Mock
        when(userRepositoryMock.existsById(id)).thenReturn(true);
        when(userRepositoryMock.getFollowers(id)).thenReturn(followers);
        when(userRepositoryMock.findById(id)).thenReturn(seller);

        // Act y Assert
        Assertions.assertThrows(OrderInvalidException.class, () -> userService.getFollowers(id, "not found"));
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento ascendente sobre followers")
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
    @DisplayName("T-0004 Verificar el correcto ordenamiento descendente sobre followers")
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
    @DisplayName("T-0005 Verificar que el tipo de ordenamiento por fecha exista (null) (US-0009)")
    public void test0005DateOrderExists() {
        // Arrange
        int userId = 1;
        String order = null;
        User user = UserFactory.userWithId(userId);

        when(userRepositoryMock.existsById(userId)).thenReturn(true);
        when(userRepositoryMock.findById(userId)).thenReturn(user);

        int expectedSize = 0;

        // Act
        RecentPostsDtoRes recentPosts = userService.getRecentPosts(userId, order);

        // Assert
        assertEquals(expectedSize, recentPosts.getPosts().size());

    }

    @Test
    @DisplayName("T-0005 Verificar que el tipo de ordenamiento por fecha exista (String no válido) (US-0009)")
    public void test0005DateOrderNotExists() {
        // Arrange
        int userId = 1;
        String order = "not an order";
        User user = UserFactory.userWithId(userId);

        when(userRepositoryMock.existsById(userId)).thenReturn(true);
        when(userRepositoryMock.findById(userId)).thenReturn(user);

        // Act / Assert
        assertThrows(OrderInvalidException.class, ()->userService.getRecentPosts(userId, order));

    }

    @Test
    @DisplayName("T-0006 Verificar el correcto ordenamiento " +
            "descendente por fecha. (date_desc) (US-0009)")
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
            "ascendente por fecha. (date_asc) (US-0009)")
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
        assertAll(()->{
            assertEquals(expectedSize, recentPosts.getPosts().size());
            assertEquals(today.minusDays(2), recentPosts.getPosts().get(0).getDate());
        });
    }

}
