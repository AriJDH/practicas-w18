package com.sprint1.be_java_hisp_w18_g03.units.service;

import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundException;
import com.sprint1.be_java_hisp_w18_g03.exception.ParamException;
import com.sprint1.be_java_hisp_w18_g03.service.IPostService;
import com.sprint1.be_java_hisp_w18_g03.service.UserServiceImp;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.utils.PostFactor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    @DisplayName("T-00001 Verificar que el usuario a seguir exista. (US-0001) :D")
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
    @DisplayName("T-00001 Verificar que el usuario a seguir exista. (US-0001) D: no existe usuario a seguir")
    public void verifyFollowTestUserToFollowNotFound(){
        //Arrange
        User userFollower = getUser(1, "Juan");
        User userToFollow = getUser(2, "Federico");
        Post post = PostFactor.getPost(2, userToFollow);
        List<Post> posts = new ArrayList<>();
        posts.add(post);

        //Mock
        when(userRepository.findById(userFollower.getUserId())).thenReturn(userFollower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(null);
        /*when(postRepository.findByUser(userToFollow.getUserId())).thenReturn(posts);*/

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
    public void getFollowedListNoOk(){
        //ACT
        List<User> ListUser = new ArrayList<>();
        ListUser.add(new User(99,"luis",null,null));
        User userTest = new User(1,"juan",ListUser, ListUser);
        //ACT
        NoFoundException noFoundException = Assertions.assertThrows(NoFoundException.class,()->
                userServiceImp.getFollowedList(userTest.getUserId(),anyString())
        );
        //ASSERT
        Assertions.assertNotNull(noFoundException);
    }

}
