package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Product;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.entity.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class UserRepositoryImp {
    List<User> users;
    List<Seller> sellers;

    public UserRepositoryImp(){
        //Carga de Datos inicial
        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

        Seller s1= new Seller(5,"User5",followed,posts,followers);
        Seller s2= new Seller(6,"User6",followed,posts,followers);
        Seller s3= new Seller(3,"User3",followed,posts,followers);
        Seller s4= new Seller(4,"User4",followed,posts,followers);


        User u1 = new User(1,"User1",followed);
        User u2 = new User(2,"User2",followed);
        User u3 = new User(3,"User3",followed);
        User u4 = new User(4,"User4",followed);

        Product pr1 = new Product(1,"Product1","Type1","Brand1","Color1","Notes1");
        Product pr2 = new Product(2,"Product2","Type2","Brand2","Color2","Notes2");
        Product pr3 = new Product(3,"Product3","Type3","Brand3","Color3","Notes3");
        Product pr4 = new Product(4,"Product4","Type4","Brand4","Color4","Notes4");

        LocalDate date = LocalDate.parse("12-11-2022");
        Post ps1 = new Post(1,3,pr1,1,111.11,date);
        Post ps2 = new Post(2,4,pr1,2,222.22,date.plusDays(15));
        Post ps3 = new Post(3,5,pr1,3,333.33,date.plusDays(20));
        Post ps4 = new Post(4,6,pr1,4,444.44,date.minusDays(14));

        posts.add(ps1);
        posts.add(ps2);
        posts.add(ps3);
        posts.add(ps4);

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
}
