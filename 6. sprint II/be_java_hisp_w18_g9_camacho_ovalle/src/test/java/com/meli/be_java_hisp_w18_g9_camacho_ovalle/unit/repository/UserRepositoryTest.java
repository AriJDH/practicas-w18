package com.meli.be_java_hisp_w18_g9_camacho_ovalle.unit.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    // ? =============== Attributes =============== ?

    @Autowired
    private UserRepository userRepository;

    // ? =============== Before =============== ?

    @BeforeEach
    public void setUp() {
        userRepository.save(new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        userRepository.save(new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        userRepository.save(new User(3, "User test 3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }

    // ? =============== Tests =============== ?

    @Test
    @DisplayName("Find all users")
    void findAll() {
        assertTrue(userRepository.findAll().size() > 0);
        assertNotNull(userRepository.findAll().get(0));
        assertFalse(userRepository.findAll().isEmpty());
        assertEquals(3, userRepository.findAll().size());
    }

    // * =============== *

    @Test
    @DisplayName("Find user by Id")
    void findById() {
        assertNotNull(userRepository.findById(1));
        assertEquals(1, userRepository.findById(1).get().getUserId());
        assertEquals("User test 1", userRepository.findById(1).get().getUserName());
    }

    // * =============== *

    @Test
    @DisplayName("Find user by Id - Not found")
    void findByIdNotFound() {
        Integer random = (int) (Math.random() * 900) + 100;
        assertEquals(Optional.empty(), userRepository.findById(random));
    }

    // * =============== *

    @Test
    @DisplayName("Save user")
    void save() {
        userRepository.save(new User(4, "User test 4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        assertEquals(4, userRepository.findAll().size());
        assertEquals(4, userRepository.findById(4).get().getUserId());
        assertEquals("User test 4", userRepository.findById(4).get().getUserName());
    }

    // * =============== *

    @Test
    @DisplayName("Delete user by Id")
    void deleteById() {
        userRepository.deleteById(1);
        assertEquals(Optional.empty(), userRepository.findById(1));
    }

    // * =============== *

    @Test
    @DisplayName("Delete user by Id - Not found")
    void deleteByIdNotFound() {
        userRepository.deleteById(4);
        assertEquals(3, userRepository.findAll().size());
    }

    // * =============== *

    @Test
    @DisplayName("Update user")
    void update() {
        User user = userRepository.findById(1).get();
        user.setUserName("User test 1 - Updated");
        userRepository.update(user);
        assertEquals("User test 1 - Updated", userRepository.findById(1).get().getUserName());
    }

    // * =============== *

    @Test
    @DisplayName("Update user - Not found")
    void updateNotFound() {
        Integer random = (int) (Math.random() * 900) + 100;
        User user = new User(random, "User test 4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userRepository.update(user);
        assertEquals(Optional.empty(), userRepository.findById(random));
    }

    // ? =============== After =============== ?

    @AfterEach
    public void tearDown() {
        userRepository.findAll().removeIf(user -> user.getUserId() != null);
    }
}