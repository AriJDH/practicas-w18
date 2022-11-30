package com.socialmeli2.be_java_hisp_w18g05.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli2.be_java_hisp_w18g05.dto.response.ErrorExceptionDTOResponse;
import com.socialmeli2.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.socialmeli2.be_java_hisp_w18g05.utils.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;


    @Nested
    @DisplayName("testUS0001")
    class T0001 {
        @Test
        @DisplayName("OK")
        void OK() throws Exception {
            //======= Arrange ================
            Integer buyerId = 5;
            Integer sellerId = 50;
            //======= Act & Assert ===========
            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        }

        @Test
        @DisplayName("NO OK // Buyer Not found")
        void BuyerNotFound() throws Exception {
            //======= Arrange ================
            Integer buyerId = 100;
            Integer sellerId = 60;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("Buyer id " + buyerId + " not found", HttpStatus.NOT_FOUND.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }

        @Test
        @DisplayName("NO OK // Seller Not found")
        void SellerNotFound() throws Exception {
            //======= Arrange ================
            Integer buyerId = 4;
            Integer sellerId = 100;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("Seller id " + sellerId + " not found", HttpStatus.NOT_FOUND.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }

        @Test
        @DisplayName("NO OK // The buyer is already following the seller")
        void AlreadyFollowing() throws Exception {
            //======= Arrange ================
            Integer buyerId = 5;
            Integer sellerId = 50;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("The buyer id " + buyerId +" is already following the seller id " + sellerId, HttpStatus.BAD_REQUEST.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }
    }

    @Test
    @DisplayName("testUS0002")
    void testUS0002() throws Exception{
        //======= Arrange =======
        Integer userId = 60;
        SellerFollowersCountDTOResponse response = getSellerWith2Follows(userId);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String responseDto = writer.writeValueAsString(response);
        //======= Act ===========
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //======= Assert ========
        assertEquals(responseDto,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("testUS0005")
    void testUS0005 () throws Exception {
        //======= Arrange ================
        NewPostDTORequest postDto = getPostDTORequest1(10);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(postDto);
        //======= Act & Assert ===========
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Nested
    @DisplayName("testUS0007")
    class T0007 {
        @Test
        @DisplayName("OK")
        void testUS0007() throws Exception {
            //======= Arrange ================
            Integer buyerId = 1;
            Integer sellerId = 60;
            //======= Act & Assert ===========
            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        }

        @Test
        @DisplayName("NO OK // Buyer Not found")
        void BuyerNotFound() throws Exception {
            //======= Arrange ================
            Integer buyerId = 100;
            Integer sellerId = 60;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("Buyer id " + buyerId + " not found", HttpStatus.NOT_FOUND.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }

        @Test
        @DisplayName("NO OK // Seller Not found")
        void SellerNotFound() throws Exception {
            //======= Arrange ================
            Integer buyerId = 4;
            Integer sellerId = 100;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("Seller id " + sellerId + " not found", HttpStatus.NOT_FOUND.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }

        @Test
        @DisplayName("NO OK // The buyer doesn´t follow the seller")
        void DoesntFollow() throws Exception {
            //======= Arrange ================
            Integer buyerId = 5;
            Integer sellerId = 60;
            ErrorExceptionDTOResponse errorDto = new ErrorExceptionDTOResponse("The buyer id " + buyerId +" does not follow the seller id " + sellerId, HttpStatus.BAD_REQUEST.value());
            ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                    .writer();
            String errorExpected = writer.writeValueAsString(errorDto);
            //======= Act ====================
            MvcResult mvcResult= mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", buyerId, sellerId))
                    .andDo(print())
                    .andReturn();
            //======= Assert =================
            assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
        }

    }

}
