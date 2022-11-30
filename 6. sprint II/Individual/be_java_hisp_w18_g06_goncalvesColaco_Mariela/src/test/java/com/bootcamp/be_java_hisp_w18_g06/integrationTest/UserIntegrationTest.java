package com.bootcamp.be_java_hisp_w18_g06.integrationTest;

import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.UserService;
import com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	IUserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Test
	@DisplayName("T0011 - Post - Seguir un usuario happy path =^.^=")
	void followUserOkTest() throws Exception {
		
		User seller = UserFactory.getUserWithFollowersListAndPosts("seller");
		User buyer = UserFactory.getUserWithFollowedList("buyer");
		
		seller.setUserId(3);
		buyer.setUserId(4);
		
		when(userRepository.findUserById(3))
						.thenReturn(Optional.of(seller));
		
		when(userRepository.findUserById(4))
						.thenReturn(Optional.of(buyer));
		
		MvcResult mvcResult = mockMvc
						.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 3))
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
		
	}
	
	@Test
	@DisplayName("T0012 - Post - Dejar de seguir un usuario happy path =^.^=")
	void unfollowUserOkTest() throws Exception {
		User seller = UserFactory.getUserWithFollowersListAndPosts("seller");
		User buyer = UserFactory.getUserWithFollowedList("buyer");
		List<User> followers = Collections.singletonList(buyer);
		List<User> followed = Collections.singletonList(seller);
		
		seller.setUserId(3);
		buyer.setUserId(4);
		seller.setFollowers(followers);
		buyer.setFollowed(followed);
		
		when(userRepository.findUserInList(anyList(), eq(3)))
						.thenReturn(Optional.of(seller));
		
		when(userRepository.findUserInList(anyList(), eq(4)))
						.thenReturn(Optional.of(buyer));
		
		when(userRepository.findUserById(3))
						.thenReturn(Optional.of(seller));
		
		when(userRepository.findUserById(4))
						.thenReturn(Optional.of(buyer));
		
		MvcResult mvcResult = mockMvc
						.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4, 3))
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
		
	}
	
	@Test
	@DisplayName("T0013 - Get - Contar seguidores happy path =^.^=")
	void getFollowersCountOkTest() throws Exception {
		
		User seller = UserFactory.getUserWithFollowersListAndPosts("seller");
		
		when(userRepository.findUserById(anyInt()))
						.thenReturn(Optional.of(seller));
		
		MvcResult mvcResult = mockMvc
						.perform(get("/users/{userId}/followers/count", 1))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	
	@Test
	@DisplayName("T0014 - Get - Obtener lista de seguidos happy path =^.^=")
	void getFollowedListOkTest() throws Exception {
		
		User buyer = UserFactory.getUserWithFollowedList("buyer");
		
		when(userRepository.findUserById(anyInt()))
						.thenReturn(Optional.of(buyer));
		
		MvcResult mvcResult = mockMvc
						.perform(get("/users/{userId}/followed/list", 1))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
		
	}
	
	@Test
	@DisplayName("T0015 - Get - Obtener lista de seguidores happy path =^.^=")
	void getFollowersListOkTest() throws Exception {
		
		User seller = UserFactory.getUserWithFollowersList("seller");
		
		when(userRepository.findUserById(anyInt()))
						.thenReturn(Optional.of(seller));
		
		MvcResult mvcResult = mockMvc
						.perform(get("/users/{userId}/followed/list", 1))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
		
	}
	
}
