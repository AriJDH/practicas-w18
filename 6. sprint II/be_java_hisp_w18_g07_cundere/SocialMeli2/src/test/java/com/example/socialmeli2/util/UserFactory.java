package com.example.socialmeli2.util;

import com.example.socialmeli2.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFactory {

    /**
     * Generates an unordered list of 3 users with name and id set
     *
     * @return List of unordered users
     */
    public static List<UserEntity> getUserListUnordered() {
        List<UserEntity> userEntityList = new ArrayList<>();

        UserEntity userFollowed1 = new UserEntity();
        userFollowed1.setId(11);
        userFollowed1.setName("Tunisia");
        UserEntity userFollowed2 = new UserEntity();
        userFollowed2.setId(22);
        userFollowed2.setName("Amelie");
        UserEntity userFollowed3 = new UserEntity();
        userFollowed3.setId(33);
        userFollowed3.setName("Charly");

        userEntityList.add(userFollowed1);
        userEntityList.add(userFollowed2);
        userEntityList.add(userFollowed3);

        return userEntityList;
    }

    /**
     * Generates an ordered list of 3 users with name and id set, ordered ascending by name
     *
     * @return List of users ordered ascending by name
     */
    public static List<UserEntity> getUserListOrderedAsc() {
        List<UserEntity> userEntityList = new ArrayList<>();

        UserEntity userFollowed1 = new UserEntity();
        userFollowed1.setId(11);
        userFollowed1.setName("Tunisia");
        UserEntity userFollowed2 = new UserEntity();
        userFollowed2.setId(22);
        userFollowed2.setName("Amelie");
        UserEntity userFollowed3 = new UserEntity();
        userFollowed3.setId(33);
        userFollowed3.setName("Charly");

        userEntityList.add(userFollowed2);
        userEntityList.add(userFollowed3);
        userEntityList.add(userFollowed1);

        return userEntityList;
    }

    /**
     * Generates an ordered list of 3 users with name and id set, ordered descending by name
     *
     * @return List of users ordered descending by name
     */
    public static List<UserEntity> getUserListOrderedDesc() {
        List<UserEntity> userEntityList = new ArrayList<>();

        UserEntity userFollowed1 = new UserEntity();
        userFollowed1.setId(11);
        userFollowed1.setName("Tunisia");
        UserEntity userFollowed2 = new UserEntity();
        userFollowed2.setId(22);
        userFollowed2.setName("Amelie");
        UserEntity userFollowed3 = new UserEntity();
        userFollowed3.setId(33);
        userFollowed3.setName("Charly");

        userEntityList.add(userFollowed1);
        userEntityList.add(userFollowed3);
        userEntityList.add(userFollowed2);

        return userEntityList;
    }

    /**
     * Generates a user entity with name, id and 3 followers
     *
     * @return User entity with followers
     */
    public static UserEntity getUserWithFollowers(Integer userId, String userName) {
        UserEntity user = new UserEntity();

        user.setId(userId);
        user.setName(userName);
        user.setFollowersList(List.of(11, 22, 33));

        return user;
    }

    public static UserEntity getUserWithFolloweds(Integer userId, String userName) {
        List<Integer> followedList = new ArrayList<>();
        followedList.add(2);
        List<Integer> followersList = new ArrayList<>();
        List<Integer> publicationList = new ArrayList<>();
        UserEntity user = new UserEntity(userId, userName, followersList, followedList, publicationList);

        return user;
    }

    public static UserEntity getUserWithFollowersAndPublicationsAsc(Integer userId, String userName) {
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName(userName);
        user.setFollowersList(List.of(11, 22, 33));
        List<Integer> publicationList = new ArrayList<>(Arrays.asList(1, 2));
        user.setPublicationList(publicationList);

        return user;
    }

    public static UserEntity getUserWithFollowersAndPublicationsDesc(Integer userId, String userName) {
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName(userName);
        user.setFollowersList(List.of(11, 22, 33));
        List<Integer> publicationList = new ArrayList<>(Arrays.asList(2, 1));
        user.setPublicationList(publicationList);

        return user;
    }

    public static UserEntity getUserWithFollowersAndPublicationsRandomDate(Integer userId, String userName) {
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setName(userName);
        user.setFollowersList(List.of(11, 22, 33));
        List<Integer> publicationList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        user.setPublicationList(publicationList);

        return user;
    }

}


