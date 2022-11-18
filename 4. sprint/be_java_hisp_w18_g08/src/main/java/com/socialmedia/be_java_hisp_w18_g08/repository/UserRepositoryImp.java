package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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

        List<Post> post3 = new ArrayList<>();
        List<Post> post4 = new ArrayList<>();
        List<Post> post5 = new ArrayList<>();
        List<Post> post6 = new ArrayList<>();

        post3.add(postRepository.getPosts().get(0));
        post4.add(postRepository.getPosts().get(1));
        post5.add(postRepository.getPosts().get(2));
        post6.add(postRepository.getPosts().get(3));


        Seller s3 = new Seller(3, "User3", followed, post3, followers);
        Seller s4 = new Seller(4, "User4", followed, post4, followers);
        Seller s1 = new Seller(5, "User5", followed, post5, followers);
        Seller s2 = new Seller(6, "User6", followed, post6, followers);


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
    public List<String> follow(Integer userId, Integer userIdToFollow) {

        List<String> nombres = new ArrayList<>();

        for (User u : this.users) {
            if (u.getUser_id() == userId) {
                nombres.add(u.getUser_name());
                for (Seller s : this.sellers) {
                    if (s.getUser_id() == userIdToFollow) {
                        nombres.add(s.getUser_name());
                        u.getFollowed().add(s);
                        break;
                    }
                }
                break;
            }
        }

        if (nombres.size() < 2) {
            return null;
        }
        return nombres;
    }
}
