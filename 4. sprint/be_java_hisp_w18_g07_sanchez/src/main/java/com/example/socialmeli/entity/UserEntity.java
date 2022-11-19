package com.example.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private Integer id;
    private String name;
    private List<Integer> followersList;   //Almacena los ids de los usuarios que nos siguen
    private List<Integer> followedList;   //Almacena los ids de los usuarios que seguimos
    private List<Integer> publicationList; //Almacena los ids de las publicaciones relacionadas al usuario
    private List<Integer> promProductsList; //Almacena los ids de los productos en promocion del usuario


    public void addFollowersToList(Integer userId){
        followersList.add(userId);
    }

    public void removeFollowersToList(Integer userId){
        followersList.remove(userId);
    }

    public void addFollowedList(Integer userId){
        followedList.add(userId);
    }


    public void removeFollowedToList(Integer userId){
        followedList.remove(userId);
    }

    public void addPromProductsList(Integer userId){promProductsList.add(userId);}
}
