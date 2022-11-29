package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.PostService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static com.bootcamp.be_java_hisp_w18_g06.utils.PostFactory.getPost;
import static com.bootcamp.be_java_hisp_w18_g06.utils.PostFactory.getPostDto;
import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserRandom;
import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserWithFollowersListAndPosts;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private PostService postService;

    //nomenclatura del nombre:
    // nombre del método + resultado esperado + test
    //ej: savePostOkTest()


    //US00006
    @Nested
    class T0008{
        @Test
        void findAllPostsByUserFromLastTwoWeeksTest() {
            //Arrange
            User seller=getUserWithFollowersListAndPosts("Marco");
            User buyer=getUserRandom("Daniela");
            buyer.setFollowed(Collections.singletonList(seller));
            List<PostDTO>expectList=getPostDto();

            //Mock
            when(userRepository.findUserById(buyer.getUser_id())).thenReturn(Optional.of(buyer));

            //act
            List<PostDTO>result=postService
                    .findAllPostsByUser(buyer.getUser_id(),null);
            //assert
            assertArrayEquals(expectList.toArray(),result.toArray());


        }

    }
    //US00009
    @Nested
    class T0005{
        @Test
        void findAllPostsByUserOkTest() {
            //arrange
            int id=1;
            String orderAsc="date_asc";
            User userToAnalyze=getUserRandom("Romina");
            User userFollowed=getUserRandom("Damian");
            userFollowed.setFollowers(Collections.singletonList(userToAnalyze));
            userFollowed.setPosts(Collections.singletonList(getPost(id)));
            userToAnalyze.setFollowed(Collections.singletonList(userFollowed));
            //mock
            when(userRepository.findUserById(id)).thenReturn(Optional.of(userToAnalyze));
            //act
            List<PostDTO> posts=postService.findAllPostsByUser(id,orderAsc);
            //assert
            assertTrue(posts.size()!=0);
        }
        @Test
        void findAllPostsByUserExceptionTest() {
            //arrange
            int id=1;
            String orderAsc="BadRequest";
            User userToAnalyze=getUserRandom("Romina");
            User userFollowed=getUserRandom("Damian");
            userFollowed.setFollowers(Collections.singletonList(userToAnalyze));
            userFollowed.setPosts(Collections.singletonList(getPost(id)));
            userToAnalyze.setFollowed(Collections.singletonList(userFollowed));

            //mock
            when(userRepository.findUserById(id)).thenReturn(Optional.of(userToAnalyze));
            //act-assert
            assertThrows(BadRequestException.class,()->postService.findAllPostsByUser(id,orderAsc));

        }

    }

    //US00009
    @Nested
    class T0006{
        @Test
        void findAllPostsByUserAscOkTest() {

            //arrange
            int idUser=1;
            String asc="date_asc";

            User userFollowed1=getUserWithFollowersListAndPosts("vendedor");
            User userRequest=getUserRandom("comprador");
            userRequest.setFollowed(Collections.singletonList(userFollowed1));

            //mock
            when(userRepository.findUserById(idUser)).thenReturn(Optional.of(userRequest));
            //act
           List<PostDTO>postDTOS = postService.findAllPostsByUser(idUser,asc);
            //assert
            assertEquals(0, userRequest.getFollowed().get(0).getPosts().get(1).getDate()
                    .compareTo(postDTOS.get(0).getDate()));
        }
        @Test
        void findAllPostsByUserDescOkTest() {

            //arrange
            int idUser=1;
            String asc="date_desc";

            User userFollowed1=getUserWithFollowersListAndPosts("vendedor");
            User userRequest=getUserRandom("comprador");
            userRequest.setFollowed(Collections.singletonList(userFollowed1));

            //mock
            when(userRepository.findUserById(idUser)).thenReturn(Optional.of(userRequest));
            //act
            List<PostDTO>postDTOS = postService.findAllPostsByUser(idUser,asc);

            System.out.println(userRequest.getFollowed().get(0).getPosts().get(2).getDate().compareTo(postDTOS.get(0).getDate()));
            System.out.println(userRequest.getFollowed().get(0).getPosts().get(2).getDate());
            //assert
            assertEquals(0, userRequest.getFollowed().get(0).getPosts().get(2).getDate().compareTo(postDTOS.get(0).getDate()));
        }

    }




}