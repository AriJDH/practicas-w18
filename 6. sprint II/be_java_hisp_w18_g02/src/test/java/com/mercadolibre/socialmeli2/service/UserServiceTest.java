package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.repository.IUserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepositoryMock;

    @InjectMocks
    IUserService userService;


}
