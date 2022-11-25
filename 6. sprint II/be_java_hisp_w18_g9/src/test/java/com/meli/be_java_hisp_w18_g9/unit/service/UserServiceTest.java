package com.meli.be_java_hisp_w18_g9.unit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    // ? ================= Attributes ================= ?

    @Mock
    private ObjectMapper mapper;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // ? ================= Tests ================= ?

    @Test
    void follow() {
    }

    // * ============= *

    @Test
    void unfollow() {
    }

    // * ============= *

    @Test
    void findAllFollowed() {
    }

    // * ============= *

    @Test
    void findUserFollowedQuantity() {
    }

    // * ============= *

    @Test
    void findAllFollowedOrderAsc() {
    }

    // * ============= *

    @Test
    void findAllFollowerOrderAsc() {
    }

    // * ============= *

    @Test
    void findAllFollowerOrderDesc() {
    }

    // * ============= *

    @Test
    void findAllFollowedOrderDesc() {
    }

    // * ============= *

    @Test
    void findAllFollower() {
    }

    // * ============= *
}