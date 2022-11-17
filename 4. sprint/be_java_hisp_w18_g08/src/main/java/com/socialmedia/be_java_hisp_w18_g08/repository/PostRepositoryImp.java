package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.entity.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class PostRepositoryImp implements IPostRepository{

    List<Post> posts = new ArrayList<>();

    public  PostRepositoryImp(){
        Product pr1 = new Product(1,"Product1","Type1","Brand1","Color1","Notes1");
        Product pr2 = new Product(2,"Product2","Type2","Brand2","Color2","Notes2");
        Product pr3 = new Product(3,"Product3","Type3","Brand3","Color3","Notes3");
        Product pr4 = new Product(4,"Product4","Type4","Brand4","Color4","Notes4");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("12-11-2022", formatter);
        Post ps1 = new Post(1,3,pr1,1,111.11,date);
        Post ps2 = new Post(2,4,pr1,2,222.22,date.plusDays(15));
        Post ps3 = new Post(3,5,pr1,3,333.33,date.plusDays(20));
        Post ps4 = new Post(4,6,pr1,4,444.44,date.minusDays(14));

        posts.add(ps1);
        posts.add(ps2);
        posts.add(ps3);
        posts.add(ps4);

    }
}
