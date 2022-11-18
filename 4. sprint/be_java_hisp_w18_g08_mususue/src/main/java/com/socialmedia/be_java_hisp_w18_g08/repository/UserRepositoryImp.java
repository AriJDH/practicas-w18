package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepositoryImp implements IUserRepository{
    List<User> users;
    List<Seller> sellers;
    IPostRepository postRepository;

    public UserRepositoryImp(PostRepositoryImp postRepository) {
        users = new ArrayList<>();
        sellers = new ArrayList<>();
        //Carga de Datos inicial
        this.postRepository = postRepository;
        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();

        List<Post> post5 = new ArrayList<>();
        List<Post> post6 = new ArrayList<>();
        List<Post> post7 = new ArrayList<>();
        List<Post> post8 = new ArrayList<>();

        post5.add(postRepository.getPosts().get(0));
        post6.add(postRepository.getPosts().get(1));
        post7.add(postRepository.getPosts().get(2));
        post8.add(postRepository.getPosts().get(3));

        Seller s1 = new Seller(5, "User5", followed, post5, followers);
        Seller s2 = new Seller(6, "User6", followed, post6, followers);
        Seller s3 = new Seller(7, "User7", followed, post7, followers);
        Seller s4 = new Seller(8, "User8", followed, post8, followers);

        User u1 = new User(1, "User1", followed);
        User u2 = new User(2, "User2", followed);
        User u3 = new User(3, "User3", followed);
        User u4 = new User(4, "User4", followed);

        followers.add(u1);
        followers.add(u2);
        followers.add(u3);
        followers.add(u4);

        followed.add(s1);
        followed.add(s2);
        followed.add(s3);
        followed.add(s4);

        this.sellers.add(s1);
        this.sellers.add(s2);
        this.sellers.add(s3);
        this.sellers.add(s4);

        this.users.add(u1);
        this.users.add(u2);
        this.users.add(u3);
        this.users.add(u4);
    }

    //refactorizar nombre
    @Override
    public Seller findSellerById(Integer id) {
        return sellers.stream()
                .filter(p -> p.getUser_id() == (id))
                .findFirst().orElse(null);
    }

    @Override
    public User getUserByID(Integer userId) {
        User found = null;
        int i = 0;
        while (i < users.size() && found == null) {
            if (users.get(i).getUser_id() == userId)
                found = users.get(i);
            i++;
        }
        return found;
    }

    @Override
    public void createPost(Post post, Integer id) {
        findSellerById(id).getPosts().add(post);
    }

    @Override
    public String follow(Integer userId, Integer userIdToFollow) {

        User follower = getUserByID(userId);
        if (follower == null) {
            follower = findSellerById(userId);
        }
        Seller seller = findSellerById(userIdToFollow);

        if(follower == null || seller==null)
            return null;

        follower.getFollowed().add(seller);
        seller.getFollowers().add(follower);

        return follower.getUser_name() +" with id: " + userId + " is following -> " + seller.getUser_name() + " with id: "+ userIdToFollow;
    }

    @Override
    public String unFollow(Integer userId, Integer userIdToUnfollow) {
           User user = getUserByID(userId);
           Seller seller = findSellerById(userIdToUnfollow);
           if(user == null || seller==null)
               return null;
           user.getFollowed().remove(seller);
           seller.getFollowers().remove(user);
           return user.getUser_name() +" with id: " + userId + " unfollow to -> " + seller.getUser_name() + " with id: "+ userIdToUnfollow;
    }

}
