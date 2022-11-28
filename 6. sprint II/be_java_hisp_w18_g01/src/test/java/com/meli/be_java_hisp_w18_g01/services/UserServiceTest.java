package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.UserDTO;
import com.meli.be_java_hisp_w18_g01.dtos.UserFollowersInfoDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import com.meli.be_java_hisp_w18_g01.services.UserService;
import com.meli.be_java_hisp_w18_g01.services.UserServiceImpl;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    List<User> users;
    @BeforeEach
    void datos(){
        User lucas = new User(1L, "lucas");
        Product product1 = new Product(1L, "Zapatillas", "Tipo de zapatilla",
                "Adadis", "Blancas", "Las mejores zapas del condado");
        Post post1 = new Post(1L, lucas, LocalDate.now(),product1,100, 20000);
        Post post2 = new Post(2L, lucas, LocalDate.of(2022,11,11),product1,100, 20000);
        Post post3 = new Post(3L, lucas, LocalDate.of(2022,10,11),product1,100, 20000);
        lucas.addPost(post1);
        lucas.addPost(post2);
        lucas.addPost(post3);

        User miguel = new User(2L, "miguel");
        User laura = new User(3L, "laura");
        User agustin = new User(4L, "agustin");

        userService.handleFollow(2, 1);
        userService.handleFollow(3, 1);
        userService.handleFollow(4, 1);

        users.add(lucas);
        users.add(laura);
        users.add(miguel);
        users.add(agustin);
    }

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserDbServiceImpl userDbService;
    private UserService userService = new UserServiceImpl(userDbService);

    //T-0001
    @Test
    public void checkUserToFollowExists(){

    }
    @Test
    public void checkUserToFollowDoesNotExist(){

    }
    //T-0002
    @Test
    public void checkUserToUnfollowExists(){

    }
    @Test
    public void checkUserToUnfollowDoesNotExist(){

    }
    //T-0003
    @Test
    public void verifyOderTypeAscExists(){
        
        //Arrange
        users = new ArrayList<>();
        Long id = 1L;
        String order = "name_asc";
        List <UserDTO> followers = Arrays.asList(
                new UserDTO(4L, "Agustin"),
                new UserDTO(3L, "Laura"),
                new UserDTO(2L, "Miguel"));

        UserFollowersInfoDTO userFollowersInfoDTOExpected = new UserFollowersInfoDTO(
                1L,
                "Lucas",
                followers
        );

        //Mock
        when(userRepository.findById(id)).thenReturn(Optional.of(users.get(0)));

        //Act
        UserFollowersInfoDTO result = userService.handleGetFollowersInfo(id, order);

        //Assert
        //Assertions.assertTrue(result.getFollowers().get(0).getUser_name()
        //        .compareTo(result.getFollowers().get(1).getUser_name()) < 0);


        Assertions.assertEquals(userFollowersInfoDTOExpected.getFollowers(),result);
    }
    @Test
    public void verifyOderTypeDescExists(){

    }
    @Test
    public void verifyOderTypeXDoesNotExist(){

    }
    //T-0004
    @Test
    public void checkAscOrderingByName(){

    }
    @Test
    public void checkDescOrderingByName(){

    }
}
