package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.response.PostDtoRes;
import com.mercadolibre.socialmeli2.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.OrderInvalidException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

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

}
