package com.meli.be_java_hisp_w18_g01.domain;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User seller;
    private Post post;
    //T-0007
    @Test
    @DisplayName("T0007 - El vendedor cuenta la cantidad de usuarios que lo siguen")
    public void verifyUserCountIsCorrect(){
        //Arrange
        seller = new User(1L,"Agustin");
        Product prod = new Product();
        post = new Post(1L, seller, LocalDate.now(),prod,4,500000);

        User user2 = new User(2L,"Marcos");
        User user3 = new User(3L,"Lucas");
        seller.addFollower(user2);
        seller.addFollower(user3);

        //Act
        Assertions.assertEquals(2,seller.getFollowersCount());
    }
}
