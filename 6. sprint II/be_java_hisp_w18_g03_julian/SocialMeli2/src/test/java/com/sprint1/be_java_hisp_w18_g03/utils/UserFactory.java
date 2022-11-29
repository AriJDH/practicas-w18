package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowedDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowersDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.UserDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static User getUser(Integer id, String name) {
        return new User(id, name, new ArrayList<>(), new ArrayList<>());
    }

    public static User getUserPostSeller() {

        User user = new User();
        user.setUserId(1);
        user.setUserName("Prueba1");
        User vendedor = getSeller();

        List<User> listFollowed = new ArrayList<>();
        listFollowed.add(vendedor);
        user.setListFollowed(listFollowed);

        user.setListFollowers(new ArrayList<>());

        return user;
    }

    public static User getSeller(){
        User vendedor = new User();
        vendedor.setUserId(2);
        vendedor.setUserName("Vendedor 1");
        return vendedor;
    }

    public static User userWithFollowers(){
        User user = getUser(1, "Juan");
        user.getListFollowers().add(getUser(2, "Pepe"));
        user.getListFollowers().add(getUser(3, "Ana"));
        user.getListFollowers().add(getUser(4, "Federico"));
        user.getListFollowers().add(getUser(5, "Jose"));
        user.getListFollowers().add(getUser(6, "Santiago"));
        return user;
    }

    public static User userWithFollowed(){
        User user = getUser(1, "Juan");
        user.getListFollowed().add(getUser(2, "Pepe"));
        user.getListFollowed().add(getUser(3, "Ana"));
        user.getListFollowed().add(getUser(4, "Federico"));
        user.getListFollowed().add(getUser(5, "Jose"));
        user.getListFollowed().add(getUser(6, "Santiago"));
        return user;
    }

    public static FollowersDTO userWithFollowersOrderAsc(){
        FollowersDTO expected = new FollowersDTO();
        expected.setUserId(1);
        expected.setUserName("Juan");
        expected.getFollowers().add(new UserDTO(3, "Ana"));
        expected.getFollowers().add(new UserDTO(4, "Federico"));
        expected.getFollowers().add(new UserDTO(5, "Jose"));
        expected.getFollowers().add(new UserDTO(2, "Pepe"));
        expected.getFollowers().add(new UserDTO(6, "Santiago"));
        return  expected;
    }

    public static FollowersDTO userWithFollowersOrderDesc(){
        FollowersDTO expected = new FollowersDTO();
        expected.setUserId(1);
        expected.setUserName("Juan");
        expected.getFollowers().add(new UserDTO(6, "Santiago"));
        expected.getFollowers().add(new UserDTO(2, "Pepe"));
        expected.getFollowers().add(new UserDTO(5, "Jose"));
        expected.getFollowers().add(new UserDTO(4, "Federico"));
        expected.getFollowers().add(new UserDTO(3, "Ana"));
        return  expected;
    }

    public static FollowedDTO userWithFollowedOrderAsc(){
        FollowedDTO expected = new FollowedDTO();
        expected.setUserId(1);
        expected.setUserName("Juan");
        expected.getFollowed().add(new UserDTO(3, "Ana"));
        expected.getFollowed().add(new UserDTO(4, "Federico"));
        expected.getFollowed().add(new UserDTO(5, "Jose"));
        expected.getFollowed().add(new UserDTO(2, "Pepe"));
        expected.getFollowed().add(new UserDTO(6, "Santiago"));
        return expected;
    }

    public static FollowedDTO userWithFollowedOrderDesc(){
        FollowedDTO expected = new FollowedDTO();
        expected.setUserId(1);
        expected.setUserName("Juan");
        expected.getFollowed().add(new UserDTO(6, "Santiago"));
        expected.getFollowed().add(new UserDTO(2, "Pepe"));
        expected.getFollowed().add(new UserDTO(5, "Jose"));
        expected.getFollowed().add(new UserDTO(4, "Federico"));
        expected.getFollowed().add(new UserDTO(3, "Ana"));
        return expected;
    }

}
