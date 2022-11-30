package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.apache.el.parser.AstString;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;

public class GeneratorDB {

    private static User usuario1 = new User(1, "usuario1");
    private static User usuario3 = new User(3, "usuario3");
    private static User usuario2 = new User(2, "usuario2");

    public static PostDTOreq getPostDTOreq(){
        PostDTOreq postDTOreq1 = new PostDTOreq();
        postDTOreq1.setUser_id(1);
        postDTOreq1.setDate("29-04-2021");
        postDTOreq1.setProduct(new ProductDTOreq(1, "silla gamer", "gamer", "racer", "black", "special edition"));
        postDTOreq1.setCategory(100);
        postDTOreq1.setPrice(1500);
        return postDTOreq1;
    }

    public static UserFollowersCountDTOres getUserFollowersCountDTOres(){
        UserFollowersCountDTOres userFollowersCountDTOres = new UserFollowersCountDTOres();
        userFollowersCountDTOres.setUser_id(2);
        userFollowersCountDTOres.setUser_name("usuario2");
        userFollowersCountDTOres.setFollowers_count(2);
        return userFollowersCountDTOres;
    }

    public static UserFollowersListDTOres getUserFollowersListDTOresASC(){

        UserDTOres userDTOres1 = new UserDTOres(usuario1.getUserId(),
                usuario1.getUserName());
        UserDTOres userDTOres2 = new UserDTOres(usuario3.getUserId(),
                usuario3.getUserName());

        UserFollowersListDTOres followersListDTOres = new UserFollowersListDTOres();
        followersListDTOres.setUser_id(usuario2.getUserId());
        followersListDTOres.setUser_name(usuario2.getUserName());
        followersListDTOres.setFollowers(Arrays.asList(userDTOres1, userDTOres2));
        return followersListDTOres;
    }

    public static UserFollowersListDTOres getUserFollowersListDTOresDESC(){

        UserDTOres userDTOres1 = new UserDTOres(usuario1.getUserId(),
                usuario1.getUserName());
        UserDTOres userDTOres2 = new UserDTOres(usuario3.getUserId(),
                usuario3.getUserName());

        UserFollowersListDTOres followersListDTOres = new UserFollowersListDTOres();
        followersListDTOres.setUser_id(usuario2.getUserId());
        followersListDTOres.setUser_name(usuario2.getUserName());
        followersListDTOres.setFollowers(Arrays.asList(userDTOres2, userDTOres1));
        return followersListDTOres;
    }

    public static UserFollowedListDTOres getUserFollowedListDTOresASC(){

        UserDTOres userDTOres2 = new UserDTOres(usuario2.getUserId(),
                usuario2.getUserName());
        UserDTOres userDTOres3 = new UserDTOres(usuario3.getUserId(),
                usuario3.getUserName());

        UserFollowedListDTOres userFollowedListDTOres = new UserFollowedListDTOres(usuario1.getUserId(),
                usuario1.getUserName(), Arrays.asList(userDTOres2, userDTOres3));
        return userFollowedListDTOres;
    }

    public static UserFollowedListDTOres getUserFollowedListDTOresDESC(){

        UserDTOres userDTOres2 = new UserDTOres(usuario2.getUserId(),
                usuario2.getUserName());
        UserDTOres userDTOres3 = new UserDTOres(usuario3.getUserId(),
                usuario3.getUserName());

        UserFollowedListDTOres userFollowedListDTOres = new UserFollowedListDTOres(usuario1.getUserId(),
                usuario1.getUserName(), Arrays.asList(userDTOres3, userDTOres2));
        return userFollowedListDTOres;
    }

    public static UserPostsDTOres getUserPostsDTOresASC(){
        UserPostsDTOres userPostsDTOres = new UserPostsDTOres();

        ProductDTOres product = new ProductDTOres(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");
        ProductDTOres product2 = new ProductDTOres(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -5);
        LocalDate nowMinus5Days = c.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        PostDTOres post2 = new PostDTOres(2,5, nowMinus5Days.format(formatter), product2,4,456);
        PostDTOres post1 = new PostDTOres(2,6, LocalDate.now().format(formatter),product,77,865);

        userPostsDTOres.setUser_id(1);
        userPostsDTOres.setPosts(Arrays.asList(post2, post1));
        return userPostsDTOres;
    }

    public static UserPostsDTOres getUserPostsDTOresDESC(){
        UserPostsDTOres userPostsDTOres = new UserPostsDTOres();

        ProductDTOres product = new ProductDTOres(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");
        ProductDTOres product2 = new ProductDTOres(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -5);
        LocalDate nowMinus5Days = c.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        PostDTOres post2 = new PostDTOres(2,5, nowMinus5Days.format(formatter), product2,4,456);
        PostDTOres post1 = new PostDTOres(2,6, LocalDate.now().format(formatter),product,77,865);

        userPostsDTOres.setUser_id(1);
        userPostsDTOres.setPosts(Arrays.asList(post1, post2));
        return userPostsDTOres;
    }


}
