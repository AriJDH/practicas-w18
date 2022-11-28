package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static User getUserWithFollowers() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(99,"luis",null,null));
        User user = new User(1,"prueba1",null,listUser);
        return user;
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

    public static User getUser(Integer id, String name){
        return new User(id, name, new ArrayList<>(), new ArrayList<>());
    }
}
