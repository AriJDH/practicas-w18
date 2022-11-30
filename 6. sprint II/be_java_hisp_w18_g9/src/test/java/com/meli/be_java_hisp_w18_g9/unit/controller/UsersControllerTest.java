package com.meli.be_java_hisp_w18_g9.unit.controller;

import com.meli.be_java_hisp_w18_g9.controller.UsersController;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class UsersControllerTest {
@Mock
private IUserService userService;

@InjectMocks

private UsersController usersController;

    @Test
    @DisplayName("[T003] Test get user followers order asc (Happy path)")
    void userFollowerListOrder() {
        //Arrange
        Integer userId = 1;
        String  order = "name_asc";

        //Mock
        UserFollowerListResponse userFollowerListResponse = new UserFollowerListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
        ));
        when(userService.findAllFollower(userId)).thenReturn(userFollowerListResponse);
        //Action
        ResponseEntity<UserFollowerListResponse> userFollowerListResponseAsc = usersController.userFollowerList(userId, order);

        //Assert
        Assertions.assertNotNull(userFollowerListResponseAsc);

    }
    @Test
    @DisplayName("[T003] Test get user followers order asc (sad path)")
    void userFollowerListOrderException() {
        //Arrange
        Integer userId = 1;
        String  order = "asc";

        //Mock
        UserFollowerListResponse userFollowerListResponse = new UserFollowerListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
        ));
        when(userService.findAllFollower(userId)).thenReturn(userFollowerListResponse);
        //Action && Asert
        Assertions.assertThrows(BadRequestException.class, () -> usersController.userFollowerList(userId, order));



    }
    @Test
    @DisplayName("[T003] Test get user followers order desc (Happy path)")
    void userFollowerListOrderDesc() {
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        //Mock
        UserFollowerListResponse  userFollowerListResponse = new UserFollowerListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan"))
                );
        when(userService.findAllFollower(userId)).thenReturn(userFollowerListResponse);
        //Action
        ResponseEntity<UserFollowerListResponse> userFollowerListResponseDesc = usersController.userFollowerList(userId, order);

        //Assert
        Assertions.assertNotNull(userFollowerListResponseDesc);
    }

    @Test
    @DisplayName("[T003] Test get user followers order desc (sad path)")
    void userFollowerListOrderDescException() {
        //Arrange
        Integer userId = 1;
        String order = "desc";
        //Mock
        UserFollowerListResponse  userFollowerListResponse = new UserFollowerListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan"))
                );
        when(userService.findAllFollowerOrderDesc(userId)).thenReturn(userFollowerListResponse);
        //Action && Assert
        Assertions.assertThrows(BadRequestException.class, ()->usersController.userFollowerList(userId,order));

    }

    @Test
    @DisplayName("[T003] Test get user followed order asc (Happy path)")
    void userFollowedListOrderAsc() {
        //Arrange
        Integer userId = 1;
        String order = "name_asc";

        //Mock
        UserFollowedListResponse userFollowedListResponse = new UserFollowedListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
                ));
        when(userService.findAllFollowedOrderAsc(userId)).thenReturn(userFollowedListResponse);


        //Action
        ResponseEntity<UserFollowedListResponse> userFollowedOrderAscListResponse = usersController.userFollowedListOrder(order, userId);


        //Assert
        Assertions.assertNotNull(userFollowedOrderAscListResponse);
    }

    @Test
    @DisplayName("[T003] Test get user followed order asc (sad path)")
    void userFollowedListOrderAscException() {
        //Arrange
        Integer userId= 1;
        String order = "asc";
        //Mock
        UserFollowedListResponse userFollowedListResponse = new UserFollowedListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
                ));
        when(userService.findAllFollowedOrderAsc(userId)).thenReturn(userFollowedListResponse);
        //Action && Assert
        Assertions.assertThrows(BadRequestException.class, ()->usersController.userFollowerList(userId, order));
    }
    @Test
    @DisplayName("[T003] Test get user followed order desc (Happy path)")
    void userFollowedListOrderDesc() {
        //Arrange
        Integer userId = 1;
        String order = "name_desc";

        //Mock
        UserFollowedListResponse userFollowedListResponse = new UserFollowedListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
        ));
        when(userService.findAllFollowedOrderDesc(userId)).thenReturn(userFollowedListResponse);

        //Action
        ResponseEntity<UserFollowedListResponse> userFollowedOrderDescListResponse = usersController.userFollowedListOrder(order, userId);

        //Assert
        Assertions.assertNotNull(userFollowedOrderDescListResponse);
    }
    @Test
    @DisplayName("[T003] Test get user followed order desc (sad path)")
    void userFollowedListOrderDescException() {
        //Arrange
        Integer userId = 1;
        String order = "desc";

        //Mock
        UserFollowedListResponse userFollowedListResponse = new UserFollowedListResponse(1, "Zara", List.of(
                new UserSimpleResponse(2, "Astrid"),
                new UserSimpleResponse(3, "Juan")
        ));
        when(userService.findAllFollowedOrderDesc(userId)).thenReturn(userFollowedListResponse);

        //Action && Assert
        Assertions.assertThrows(BadRequestException.class, ()->usersController.userFollowerList(userId, order));
    }

}