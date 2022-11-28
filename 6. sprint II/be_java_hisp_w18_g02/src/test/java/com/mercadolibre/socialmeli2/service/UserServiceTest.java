package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @DisplayName("T-0004 Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
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
