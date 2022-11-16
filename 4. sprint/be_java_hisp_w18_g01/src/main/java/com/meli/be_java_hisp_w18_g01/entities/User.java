package com.meli.be_java_hisp_w18_g01.entities;

import com.meli.be_java_hisp_w18_g01.exceptions.NotSellerException;
import com.meli.be_java_hisp_w18_g01.exceptions.UserAlreadyFollowedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    private long user_id;
    @EqualsAndHashCode.Include
    private String user_name;
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public User(long user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public void addFollower(User user){
        this.followers.add(user);
    }

    public void removeFollower(User user){
        this.followers.remove(user);
    }

    public void follow(User userToFollow){
        if(userToFollow.isSeller()){
            checkIsNotAlreadyFollowed(userToFollow);
            this.followed.add(userToFollow);
            userToFollow.addFollower(this);
        }else
            throw new NotSellerException("No puede seguir al usuario " + userToFollow.getUser_id() + " porque no es un vendedor." );
    }

    public void unFollow(User userToUnfollow){
        if(isAlreadyFollowed(userToUnfollow)){
            this.followed.remove(userToUnfollow);
            userToUnfollow.removeFollower(this);
        }else
            throw new UserAlreadyFollowedException("El usuario "+ this.getUser_id()+
                    " no puede dejar de seguir al usuario " + userToUnfollow.getUser_id() + " porque actualmente no lo sigue.");
    }

    public void checkIsNotAlreadyFollowed(User userToFollow){
        if(this.isAlreadyFollowed(userToFollow))
            throw new UserAlreadyFollowedException("El usuario " + this.getUser_id() + " ya sigue al usuario " + userToFollow.getUser_id());
    }

    public boolean isAlreadyFollowed(User userCouldBeFollowed){
        return this.followed.stream().anyMatch(u->u.equals(userCouldBeFollowed));
    }
    public boolean isSeller(){
        return this.posts.size()>0;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public int getFollowersCount(){
        return this.followers.size();
    }

}
