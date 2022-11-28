package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import com.meli.be_java_hisp_w18_g01.services.UserService;
import com.meli.be_java_hisp_w18_g01.services.UserServiceImpl;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserDbServiceImpl userDbService;
    private UserService userService = new UserServiceImpl(userDbService);

    //T-0001
    @Test
    public void checkUserToFollowExists(){

    }
    @Test
    public void checkUserToFollowDoesNotExist(){

    }
    //T-0002
    @Test
    public void checkUserToUnfollowExists(){

    }
    public void checkUserToUnfollowDoesNotExist(){

    }
    //T-0003
    @Test
    public void verifyOderTypeAscExists(){

    }
    @Test
    public void verifyOderTypeDescExists(){

    }
    @Test
    public void verifyOderTypeXDoesNotExist(){

    }
    //T-0004
    @Test
    public void checkAscOrderingByName(){

    }
    @Test
    public void checkDescOrderingByName(){

    }
}
