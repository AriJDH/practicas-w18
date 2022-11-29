package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.*;

import com.example.SocialMeli2.entity.Post;
import com.example.SocialMeli2.entity.Product;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.BadRequestException;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IUserBuyerRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;

import com.example.SocialMeli2.util.PostFactory;
import com.example.SocialMeli2.util.UserBuyerFactory;

import com.example.SocialMeli2.util.UserSellerFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserBuyerServiceImpTest {
    @Mock
    IUserBuyerRepository userBuyerRepository;

    @Mock
    IUserSellerRepository userSellerRepository;

    @InjectMocks
    UserBuyerServiceImp userBuyerServiceImp;


    @Test
    @DisplayName("T-0003. US-0008. Catch the exception if order is 'invalid'")
    void orderFollowedInvalidException() {
        //Arrange
        String order = "invalid";
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();

        //Assert
        assertThrows(UserNotFoundException.class,
                ()-> userBuyerServiceImp.getFollowed(buyer.getUser_id(), order));

    }
    @Test
    @DisplayName("T-0003. US-0008. Verify the correct operation if order is 'name_asc' ")
    void orderFollowedOrderAsc(){
    //Arrange
        String order = "name_asc";
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();

    //mock
      when(userBuyerRepository.findById(1)).thenReturn(Optional.of(buyer));
      FollowedListDTORes result = userBuyerServiceImp.getFollowed(buyer.getUser_id(), order);
      verify(userBuyerRepository).findById(1);
        // Assert
        assertAll(
                ()-> assertEquals(buyer.getUser_id(), result.getUser_id()),
                ()-> assertEquals(buyer.getUser_name(), result.getUser_name()),
                ()-> assertEquals(buyer.getFollowed(), result.getFollowed())
        );

    }


    @Test
    @DisplayName("T-0001. US-0001. The user to follow exists ")
    void userToFollowExistsOK() {
        //GIVEN
        UserSeller seller = UserSellerFactory.getUserSeller();
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();

        // WHEN
        when(userBuyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));

        FollowDTORes followDTORes = userBuyerServiceImp.follow(buyer.getUser_id(), seller.getUser_id());

        String userName = followDTORes.getUserNameFollowed();
        verify(userBuyerRepository).findById(1);
        verify(userSellerRepository).findById(1);
        //THEN
        assertEquals(seller.getUser_name(), userName);
        assertAll(
                ()->{assertEquals(seller.getUser_name(), userName);},
                ()->{assertTrue(followDTORes.getUserNameFollowed().equals(seller.getUser_name()));},
                ()->{assertTrue(followDTORes.getUserName().equals(buyer.getUser_name()));}
        );
    }

    @Test
    @DisplayName("T-0001. US-0001. The user to follow doesn't exists")
    void userToFollowException() {
        Integer id = 15;

        when(userBuyerRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,
                () -> userBuyerServiceImp.follow(id, 1));

    }

    @Test
    @DisplayName("T-0002. US-0007. The user to unfollow exists")
    void userToUnfollowExistsOK() {
        // GIVEN
        UserSeller seller = UserSellerFactory.getUserSeller();
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();
        seller.getFollowers().add(buyer);
        buyer.getFollowed().add(seller);

        // WHEN
        when(userBuyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));

        UnfollowDTORes unfollowDTORes = userBuyerServiceImp.unfollow(buyer.getUser_id(), seller.getUser_id());


        assertAll(
                ()->{assertEquals(seller.getUser_name(), unfollowDTORes.getUserNameUnfollowed());},
                ()->{assertTrue(buyer.getUser_name().equals(unfollowDTORes.getUserName()));}
        );

    }

    @Test
    @DisplayName("T-0002. US-0007. The user to unfollow doesn't exists")
    void userToUnfollowException() {
        Integer id = 15;

        when(userBuyerRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userBuyerServiceImp.unfollow(id, 1));

    }

    @Test
    @DisplayName("T-0007 US-0002. Sort by date DESC")
    void sortBydateDESC() {
        Integer user_id = 1;
        UserSeller seller = UserSellerFactory.getUserSeller();
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();
        buyer.getFollowed().add(seller);


        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = PostFactory.getPost(3, LocalDate.of(2022, 11, 25), new Product(3,
                "Product 3", "Type 3", "Brand 3", "Color 3", "Notes 3"), 2, 2500.13);

        Post post2 =PostFactory.getPost(7, LocalDate.of(2022, 11, 20), new Product(7,
                "Product 7", "Type 7", "Brand 7", "Color 7", "Notes 7"), 2, 950.00);

        posts.add(post1);
        posts.add(post2);
        seller.setPosts(posts);


        List<PostDTORes> postDtoResList= new ArrayList<>();

        PostDTORes postDTORes = new PostDTORes(seller.getUser_id(), post1.getPost_id(), post1.getDate(),
                new ProductDTORes(post1.getProduct()),
                post1.getCategory(), post1.getPrice());

        PostDTORes postDTORes2 = new PostDTORes(seller.getUser_id(), post2.getPost_id(), post2.getDate(),
                new ProductDTORes(post2.getProduct()),
                post1.getCategory(), post2.getPrice());

        postDtoResList.add(postDTORes);
        postDtoResList.add(postDTORes2);


        when(userBuyerRepository.findById(user_id)).thenReturn(Optional.of(buyer));

        PostFollowedByDateDTORes followedByDateDTORes = userBuyerServiceImp.getLastPosts(user_id, "date_desc");

        assertTrue(postDtoResList.equals(followedByDateDTORes.getPosts()));

    }
    @Test
    @DisplayName("T-0007 US-0002. Sort by date ASC")
    void sortBydateASC() {
        Integer user_id = 1;
        UserSeller seller = UserSellerFactory.getUserSeller();
        UserBuyer buyer = UserBuyerFactory.getUserBuyer();
        buyer.getFollowed().add(seller);


        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = PostFactory.getPost(3, LocalDate.of(2022, 11, 25), new Product(3,
                "Product 3", "Type 3", "Brand 3", "Color 3", "Notes 3"), 2, 2500.13);

        Post post2 =PostFactory.getPost(7, LocalDate.of(2022, 11, 20), new Product(7,
                "Product 7", "Type 7", "Brand 7", "Color 7", "Notes 7"), 2, 950.00);

        posts.add(post1);
        posts.add(post2);
        seller.setPosts(posts);

        List<PostDTORes> postDtoResList= new ArrayList<>();
        PostDTORes postDTORes = new PostDTORes(seller.getUser_id(), post1.getPost_id(), post1.getDate(),
                new ProductDTORes(post1.getProduct()),
                post1.getCategory(), post1.getPrice());

        PostDTORes postDTORes2 = new PostDTORes(seller.getUser_id(), post2.getPost_id(), post2.getDate(),
                new ProductDTORes(post2.getProduct()),
                post1.getCategory(), post2.getPrice());

        postDtoResList.add(postDTORes2);
        postDtoResList.add(postDTORes);

        // ArrayList Posts
        when(userBuyerRepository.findById(user_id)).thenReturn(Optional.of(buyer));

        PostFollowedByDateDTORes followedByDateDTORes = userBuyerServiceImp.getLastPosts(user_id, "date_asc");
        assertTrue(postDtoResList.equals(followedByDateDTORes.getPosts()));

    }
}