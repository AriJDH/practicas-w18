package com.example.socialmeli2.unit.util;

import com.example.socialmeli2.dto.response.UserBasicResponse;
import com.example.socialmeli2.exception.InvalidParameterException;
import com.example.socialmeli2.util.ListSorterByOrder;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ListSorterByOrderTest {

    @Nested
    @DisplayName("T-0003 - Verify that the alphabetical ordering type exists")
    class OrderingByNameExists {
        List<UserBasicResponse> usersList;

        @BeforeEach
        void beforeEach() {
            //Arrange
            usersList = new ArrayList<>();
            usersList.add(new UserBasicResponse(2, "Brenda"));
            usersList.add(new UserBasicResponse(11, "Alberto"));
            usersList.add(new UserBasicResponse(4, "Carlos"));
        }

        @Test
        @DisplayName("Success - Valid Order")
        void test1b() {

            //Arrange
            String order = "name_asc";

            //Act
            //Assert
            Assertions.assertDoesNotThrow(() -> ListSorterByOrder.userSortedByName(usersList, order));

        }
        @Test
        @DisplayName("Success - Valid Order")
        void test1a() {

            //Arrange
            String order = "name_desc";

            //Act
            //Assert
            Assertions.assertDoesNotThrow(() -> ListSorterByOrder.userSortedByName(usersList, order));

        }

        @Test
        @DisplayName("Exception - Invalid Order")
        void test2() {

            //Arrange
            String badOrder = "price_ascc";

            //Act
            //Assert
            assertThrows(InvalidParameterException.class, () -> ListSorterByOrder.userSortedByName(usersList, badOrder));

        }
    }

}