package com.socialmedia2.be_java_hisp_w18_g08.util;

import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBFactory {

    public static void createRepository(UserRepositoryImp userRepositoryImp, PostRepositoryImp postRepositoryImp){
        Product pr1 = new Product(1,"Product1","Type1","Brand1","Color1","Notes1");
        Product pr2 = new Product(2,"Product2","Type2","Brand2","Color2","Notes2");
        Product pr3 = new Product(3,"Product3","Type3","Brand3","Color3","Notes3");
        Product pr4 = new Product(4,"Product4","Type4","Brand4","Color4","Notes4");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("12-11-2022", formatter);
        Post ps1 = new Post(1,5,pr1,1,111.11,date);
        Post ps2 = new Post(2,6,pr1,2,222.22,date.minusDays(13));
        Post ps3 = new Post(3,7,pr1,3,333.33,date.plusDays(20));
        Post ps4 = new Post(4,8,pr1,4,444.44,date.minusDays(14));

        postRepositoryImp.add(ps1);
        postRepositoryImp.add(ps2);
        postRepositoryImp.add(ps3);
        postRepositoryImp.add(ps4);

        //Carga de Datos inicial
        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();

        List<Post> post5 = new ArrayList<>();
        List<Post> post6 = new ArrayList<>();
        List<Post> post7 = new ArrayList<>();
        List<Post> post8 = new ArrayList<>();

        post5.add(ps1);
        post6.add(ps2);
        post7.add(ps3);
        post8.add(ps4);

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

        userRepositoryImp.createSeller(s1);
        userRepositoryImp.createSeller(s2);
        userRepositoryImp.createSeller(s3);
        userRepositoryImp.createSeller(s4);

        userRepositoryImp.createUser(u1);
        userRepositoryImp.createUser(u2);
        userRepositoryImp.createUser(u3);
        userRepositoryImp.createUser(u4);
    }
}
