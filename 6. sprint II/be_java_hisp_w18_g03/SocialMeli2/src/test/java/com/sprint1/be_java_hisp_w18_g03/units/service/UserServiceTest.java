package com.sprint1.be_java_hisp_w18_g03.units.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.UserDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import com.sprint1.be_java_hisp_w18_g03.service.UserServiceImp;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.utils.PostFactor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.sprint1.be_java_hisp_w18_g03.utils.UserFactor.getUser;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserServiceImp userServiceImp;

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista. (US-0001) :D")
    public void verifyFollowTestOk(){
        //Arrange
        ResponseDTO expectedDto = new ResponseDTO("All ok", 200);

        User userFollower = getUser(1, "Juan");
        User userToFollow = getUser(2, "Federico");
        Post post = PostFactor.getPost(2, userToFollow);
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        //Mock
        when(userRepository.findById(userFollower.getUserId())).thenReturn(userFollower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(userToFollow);
        when(postRepository.findByUser(userToFollow.getUserId())).thenReturn(posts);

        //Act
        ResponseDTO resultDto = userServiceImp.follow(1, 2);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedDto.getMessage(), resultDto.getMessage()),
                () -> Assertions.assertEquals(expectedDto.getCode(), resultDto.getCode())
        );
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista. (US-0001) D: no existe usuario a seguir")
    public void verifyFollowTestUserToFollowNotFound(){
        //Arrange
        User userFollower = getUser(1, "Juan");
        User userToFollow = getUser(2, "Federico");

        //Mock
        when(userRepository.findById(userFollower.getUserId())).thenReturn(userFollower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(NoFoundException.class, () -> userServiceImp.follow(1, 2));
    }

    @Test
    @DisplayName("T-0003 - Verificar que el tipo de ordenamiento para followers exista - OK")
    public void getFollowersListOk(){
        //ACT
        List<User> ListUser = new ArrayList<>();
        ListUser.add(new User(99,"luis",null,null));
        User userTest = new User(1,"juan",null, ListUser);
        //ARRANGE
        when(userRepository.findById(anyInt())).thenReturn(userTest);
        //ACT
        FollowersDTO followersDTO = userServiceImp.getFollowersList(userTest.getUserId(),"name_asc");
        //ASSERT
        Assertions.assertNotNull(followersDTO);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el tipo de ordenamiento para followers exista - NO OK")
    public void getFollowersListNoOk(){
        //ACT
        List<User> ListUser = new ArrayList<>();
        ListUser.add(new User(99,"luis",null,null));
        User userTest = new User(1,"juan",null, ListUser);
        //ACT
        NoFoundException noFoundException = Assertions.assertThrows(NoFoundException.class,()->
                userServiceImp.getFollowersList(userTest.getUserId(),anyString())
        );
        //ASSERT
        Assertions.assertNotNull(noFoundException);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el tipo de ordenamiento para followed exista - OK")
    public void getFollowedListOk(){
        //ACT
        List<User> ListUser = new ArrayList<>();
        ListUser.add(new User(99,"luis",null,null));
        User userTest = new User(1,"juan",ListUser, null);
        //ARRANGE
        when(userRepository.findById(anyInt())).thenReturn(userTest);
        //ACT
        FollowedDTO followersDTO = userServiceImp.getFollowedList(userTest.getUserId(),"name_asc");
        //ASSERT
        Assertions.assertNotNull(followersDTO);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el tipo de ordenamiento para followed exista - NO OK")
    public void getFollowedListNoOk() {
        //ACT
        List<User> ListUser = new ArrayList<>();
        ListUser.add(new User(99, "luis", null, null));
        User userTest = new User(1, "juan", ListUser, ListUser);
        //ACT
        NoFoundException noFoundException = Assertions.assertThrows(NoFoundException.class, () ->
                userServiceImp.getFollowedList(userTest.getUserId(), anyString())
        );
        //ASSERT
        Assertions.assertNotNull(noFoundException);
    }

    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista. (US-0001) :D")
    public void verifyUnfollowTestOk(){
        //Arrange
        ResponseDTO expectedDto = new ResponseDTO("Ok", 200);

        User userFollower = getUser(1, "Juan");
        User userToFollow = getUser(2, "Federico");
        userFollower.getListFollowed().add(userToFollow);
        userToFollow.getListFollowers().add(userFollower);

        //Mock
        when(userRepository.findById(userFollower.getUserId())).thenReturn(userFollower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(userToFollow);

        //Act
        ResponseDTO resultDto = userServiceImp.unfollow(1, 2);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedDto.getMessage(), resultDto.getMessage()),
                () -> Assertions.assertEquals(expectedDto.getCode(), resultDto.getCode())
        );
    }

    @Test
    @DisplayName("T-0002 Verificar que el usuario a dejar de seguir exista. (US-0001) D: no existe usuario a unfollow")
    public void verifyUnfollowTestUserToFollowNotFound(){
        //Arrange
        User userFollower = getUser(1, "Juan");
        User userToUnfollow = getUser(2, "Federico");
        userFollower.getListFollowed().add(userToUnfollow);
        userToUnfollow.getListFollowers().add(userFollower);

        //Mock
        when(userRepository.findById(userFollower.getUserId())).thenReturn(userFollower);
        when(userRepository.findById(userToUnfollow.getUserId())).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(NoFoundException.class, () -> userServiceImp.unfollow(1, 2));
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento ascendente nombre lista seguidores. (US-0008) :D")
    public void orderAscFollowersListTestOk(){
        //Arrange
        User user = getUser(1, "Juan");
        user.getListFollowers().add(getUser(2, "Pepe"));
        user.getListFollowers().add(getUser(3, "Ana"));
        user.getListFollowers().add(getUser(4, "Federico"));
        user.getListFollowers().add(getUser(5, "Jose"));
        user.getListFollowers().add(getUser(6, "Santiago"));

        FollowersDTO expected = new FollowersDTO();
        expected.setUserId(user.getUserId());
        expected.setUserName(user.getUserName());
        expected.getFollowers().add(new UserDTO(3, "Ana"));
        expected.getFollowers().add(new UserDTO(4, "Federico"));
        expected.getFollowers().add(new UserDTO(5, "Jose"));
        expected.getFollowers().add(new UserDTO(2, "Pepe"));
        expected.getFollowers().add(new UserDTO(6, "Santiago"));

        //Mock
        when(userRepository.findById(user.getUserId())).thenReturn(user);

        //Act
        FollowersDTO result = userServiceImp.getFollowersList(user.getUserId(), "name_asc");

        //Assert
        Assertions.assertIterableEquals(expected.getFollowers(), result.getFollowers());
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento descendente nombre lista seguidores. (US-0008) :D")
    public void orderDescFollowersListTestOk(){
        //Arrange
        User user = getUser(1, "Juan");
        user.getListFollowers().add(getUser(2, "Pepe"));
        user.getListFollowers().add(getUser(3, "Ana"));
        user.getListFollowers().add(getUser(4, "Federico"));
        user.getListFollowers().add(getUser(5, "Jose"));
        user.getListFollowers().add(getUser(6, "Santiago"));

        FollowersDTO expected = new FollowersDTO();
        expected.setUserId(user.getUserId());
        expected.setUserName(user.getUserName());

        expected.getFollowers().add(new UserDTO(6, "Santiago"));
        expected.getFollowers().add(new UserDTO(2, "Pepe"));
        expected.getFollowers().add(new UserDTO(5, "Jose"));
        expected.getFollowers().add(new UserDTO(4, "Federico"));
        expected.getFollowers().add(new UserDTO(3, "Ana"));


        //Mock
        when(userRepository.findById(user.getUserId())).thenReturn(user);

        //Act
        FollowersDTO result = userServiceImp.getFollowersList(user.getUserId(), "name_desc");

        //Assert
        Assertions.assertIterableEquals(expected.getFollowers(), result.getFollowers());
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento ascendente nombre lista de seguidos. (US-0008) :D")
    public void orderAscFollowedListTestOk(){
        //Arrange
        User user = getUser(1, "Juan");
        user.getListFollowed().add(getUser(2, "Pepe"));
        user.getListFollowed().add(getUser(3, "Ana"));
        user.getListFollowed().add(getUser(4, "Federico"));
        user.getListFollowed().add(getUser(5, "Jose"));
        user.getListFollowed().add(getUser(6, "Santiago"));

        FollowedDTO expected = new FollowedDTO();
        expected.setUserId(user.getUserId());
        expected.setUserName(user.getUserName());
        expected.getFollowed().add(new UserDTO(3, "Ana"));
        expected.getFollowed().add(new UserDTO(4, "Federico"));
        expected.getFollowed().add(new UserDTO(5, "Jose"));
        expected.getFollowed().add(new UserDTO(2, "Pepe"));
        expected.getFollowed().add(new UserDTO(6, "Santiago"));

        //Mock
        when(userRepository.findById(user.getUserId())).thenReturn(user);

        //Act
        FollowedDTO result = userServiceImp.getFollowedList(user.getUserId(), "name_asc");

        //Assert
        Assertions.assertIterableEquals(expected.getFollowed(), result.getFollowed());
    }

    @Test
    @DisplayName("T-0004 Verificar el correcto ordenamiento descendente nombre lista de seguidos. (US-0008) :D")
    public void orderDescFollowedListTestOk(){
        //Arrange
        User user = getUser(1, "Juan");
        user.getListFollowed().add(getUser(2, "Pepe"));
        user.getListFollowed().add(getUser(3, "Ana"));
        user.getListFollowed().add(getUser(4, "Federico"));
        user.getListFollowed().add(getUser(5, "Jose"));
        user.getListFollowed().add(getUser(6, "Santiago"));

        FollowedDTO expected = new FollowedDTO();
        expected.setUserId(user.getUserId());
        expected.setUserName(user.getUserName());

        expected.getFollowed().add(new UserDTO(6, "Santiago"));
        expected.getFollowed().add(new UserDTO(2, "Pepe"));
        expected.getFollowed().add(new UserDTO(5, "Jose"));
        expected.getFollowed().add(new UserDTO(4, "Federico"));
        expected.getFollowed().add(new UserDTO(3, "Ana"));

        //Mock
        when(userRepository.findById(user.getUserId())).thenReturn(user);

        //Act
        FollowedDTO result = userServiceImp.getFollowedList(user.getUserId(), "name_desc");

        //Assert
        Assertions.assertIterableEquals(expected.getFollowed(), result.getFollowed());
    }


}
