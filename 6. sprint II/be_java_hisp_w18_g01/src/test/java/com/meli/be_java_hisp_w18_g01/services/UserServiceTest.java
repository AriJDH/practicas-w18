package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.UserDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserDbServiceImpl userDbService;
    @Autowired
    private UserServiceImpl userService;
    private User user1 = new User(1L, "Lucas", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    private User user2 = new User(2L, "Marcos", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    private Post post = new Post(1L, user2, LocalDate.now(),new Product(), 1,10);
    private List<User> users = new ArrayList<>();
    private User lucas;
    private User miguel;
    private User laura;
    private User agustin;

    @BeforeEach
    public void configUserService(){
        userService.setUserDbService(userDbService);
    }

    @BeforeEach
    void initUsers(){
        lucas = new User(1L, "lucas");
        miguel = new User(2L, "miguel");
        laura = new User(3L, "laura");
        agustin = new User(4L, "agustin");

        Product product1 = new Product(1L, "Zapatillas", "Tipo de zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        Post post1 = new Post(1L, lucas, LocalDate.now(),product1,100, 20000);
        Post post2 = new Post(2L, lucas, LocalDate.of(2022,11,11),product1,100, 20000);
        Post post3 = new Post(3L, lucas, LocalDate.of(2022,10,11),product1,100, 20000);

        lucas.addPost(post1);
        lucas.addPost(post2);
        lucas.addPost(post3);

        miguel.follow(lucas);
        laura.follow(lucas);
        agustin.follow(lucas);

        users.add(lucas);
        users.add(laura);
        users.add(miguel);
        users.add(agustin);
    }

    //T-0001
    @Test
    @DisplayName("T0001 - Verifica que el usuario a dejar de seguir existe")
    public void checkUserToFollowExists(){
        //Arrange
        user2.addPost(post);

        //Mock
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        //Act
        userService.handleFollow(1L,2L);

        //Assert
        assertTrue(user1.getFollowed().contains(user2));
    }
    @Test
    @DisplayName("T0002 - Usuario a seguir no existe y lanza excepción")
    public void checkUserToFollowDoesNotExist(){
        //Mock
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        //Act-Assert
        assertThrows(UserNotFoundException.class, ()->userService.handleFollow(1L,2L));
    }
    //T-0002
    @Test
    @DisplayName("T0002 - Verifica que un usuario deja de seguir a otro usuario")
    public void checkUserToUnfollowExists(){
        //Arrange
        user2.addPost(post);

        //Mock
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        //Act
        user1.follow(user2);
        userService.handleUnfollow(1L, 2L);

        //Assert
        assertFalse(user1.getFollowed().contains(user2));
    }
    @Test
    @DisplayName("T0002 - Usuario a dejar de seguir no existe y lanza excepción")
    public void checkUserToUnfollowDoesNotExist(){
        //Arrange
        user2.addPost(post);

        //Mock
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        //Act-Assert
        assertThrows(UserNotFoundException.class, ()->userService.handleUnfollow(1L,2L));
    }
    //T-0003
    @Test
    @DisplayName("T0003 - Verificación de tipo de orden válido por nombre ascendente")
    public void verifyOderTypeAscExists(){
        //Arrange
        Long id = 1L;
        String order = "name_asc";

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act-Assert
        Assertions.assertDoesNotThrow(() -> userService.handleGetFollowersInfo(id, order));


    }
    @Test
    @DisplayName("T0003 - Verificación de tipo de orden válido por nombre descendente")
    public void verifyOderTypeDescExists(){
        //Arrange
        Long id = 1L;
        String order = "name_desc";

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act-Assert
        Assertions.assertDoesNotThrow(() -> userService.handleGetFollowersInfo(id, order));
    }
    @Test
    @DisplayName("T0003 - Verificación de tipo de orden por nombre no existente")
    public void verifyOderTypeXDoesNotExist(){
        //Arrange
        Long id = 1L;
        String order = "cualquier tipo de orden que no existe";

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act-Assert
        Assertions.assertThrows(BadRequestException.class,() -> userService.handleGetFollowersInfo(id, order));
    }
    //T-0004
    @Test
    @DisplayName("T0004 - Ordenamiento de usuarios por nombre ascendente")
    public void checkAscOrderingByName(){
        //Arrange
        Long id = 1L;
        String order = "name_asc";
        List <UserDTO> followers = Arrays.asList(
                new UserDTO(4L, "agustin"),
                new UserDTO(3L, "laura"),
                new UserDTO(2L, "miguel"));

        UserFollowersInfoDTO userFollowersInfoDTOExpected = new UserFollowersInfoDTO(
                id,
                "Lucas",
                followers
        );

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act
        UserFollowersInfoDTO result = userService.handleGetFollowersInfo(id, order);

        //Assert
        Assertions.assertArrayEquals(userFollowersInfoDTOExpected.getFollowers().toArray(),result.getFollowers().toArray());
    }
    @Test
    @DisplayName("T0004 - Ordenamiento de usuarios por nombre descendente")
    public void checkDescOrderingByName(){
        //Arrange
        Long id = 1L;
        String order = "name_desc";
        List <UserDTO> followers = Arrays.asList(
                new UserDTO(2L, "miguel"),
                new UserDTO(3L, "laura"),
                new UserDTO(4L, "agustin"));

        UserFollowersInfoDTO userFollowersInfoDTOExpected = new UserFollowersInfoDTO(id,
                "Lucas",
                followers
        );

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act
        UserFollowersInfoDTO result = userService.handleGetFollowersInfo(id, order);

        //Assert
        Assertions.assertArrayEquals(userFollowersInfoDTOExpected.getFollowers().toArray(),result.getFollowers().toArray());
    }
}
