package com.socialmedia2.be_java_hisp_w18_g08.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.SellerFollowersCountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void test() throws Exception {
        //
        SellerFollowersCountDto sellerFollowersCountDto = new SellerFollowersCountDto();
        sellerFollowersCountDto.setUser_id(5);
        sellerFollowersCountDto.setUser_name("User5");
        sellerFollowersCountDto.setFollowers_count(4);

        String expectedCount = new ObjectMapper().writeValueAsString(sellerFollowersCountDto);
        /*Matchers*/
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedCount);
        /*Request*/
        MockHttpServletRequestBuilder requestUrl = MockMvcRequestBuilders
                .get("/users/5/followers/count");
        // Act & assert
        mockMvc
                .perform(requestUrl)
                .andDo(print())
                .andExpectAll(expectedStatus,expectedJson);
    }

    /*    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDto> findAllFollowersQuantity(@PathVariable
                                                                            @NotNull(message = "El  id no puede estar vacío.")
                                                                            @Min(value = 0, message = "El id debe ser mayor a cero")
                                                                            Integer userId){
    return new ResponseEntity<>(userService.findAllFollowersQuantity(userId), HttpStatus.OK);
    */
}
