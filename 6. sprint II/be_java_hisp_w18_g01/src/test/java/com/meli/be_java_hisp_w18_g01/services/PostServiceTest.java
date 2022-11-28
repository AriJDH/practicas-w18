package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.services.PostService;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    private UserDbService userDbService;
    @InjectMocks
    private PostService postService;
    //T-0005
    @Test
    public void verifyOderTypeAscByDateExists(){

    }
    @Test
    public void verifyOderTypeDescByDateExists(){

    }
    @Test
    public void verifyOderTypeXDoesNotExist(){

    }
    //T-0006
    @Test
    public void checkAscOrderingByDate(){

    }
    @Test
    public void checkDescOrderingByDate(){

    }
    //T-0008
    @Test
    public void verifyPostsAreFromLast2Weeks(){

    }

}
