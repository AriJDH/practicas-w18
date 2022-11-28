package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.UserService;
import com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.Optional;

import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserWithFollowedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceTest {
	
	@Mock
	UserRepository repository;
	@InjectMocks
	UserService service;
	
	//US0001
	@Nested
	class T0001 {
		@Test
		void verifyUserToFollowExistsOk() {
			//verificar que el usuario a seguir exista
		}
		
		@DisplayName("FollowUserNotOK")
		@Test
		void followUserNotOk() {
		}
	}
	
	
	//US0007
	@Nested
	class T0002 {
		@Test
		void unfollowUser() {
		}
	}
	
	//US-0008
	@Nested
	class T0003 {
		@Test
		void getFollowedListOk() {
			String order = "name_asc";
			User user = getUserWithFollowedList("user with followed list");
			
			when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
			Assertions.assertDoesNotThrow(() -> service.getFollowedList(user.getUser_id(), order));
			
		}
		
		@Test
		void getFollowedListNotOk() {
			String order = "order not found";
			User user = getUserWithFollowedList("user with followed list");
			
			when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
			Assertions.assertThrows(BadRequestException.class,
			                        () -> service.getFollowedList(user.getUser_id(), order));
		}
	}
	
	//US-0008
	@Nested
	class T0004 {
		@Test
		void getFollowedListAsc() {
			String order = "name_asc";
			User user = getUserWithFollowedList("user with followed list asc");
			
			when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
			
			UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
			assertEquals("user 1", result.getFollowed().get(0).getUser_name());
		}
		
		@Test
		void getFollowedListDesc() {
			String order = "name_desc";
			User user = getUserWithFollowedList("user with followed list desc");
			
			when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
			
			UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
			assertEquals("user 3", result.getFollowed().get(0).getUser_name());
		}
	}
	
	//US0002
	@Nested
	class T0007 {
		
		// Testear que devuelva la cantidad correcta de usuarios
		@Test
		@DisplayName("US0002/T0007 - Calcula correctamente la cantidad total de seguidores")
		void getFollowersListOkTest() {
			
			// ARRANGE
			User user = UserFactory.getUserWithFollowersList("user1");
			
			//MOCKS - ACT
			when(repository.findUserById(1))
							.thenReturn(Optional.of(user));
			
			UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO();
			userFollowersCountDTO.setFollowers_count(3);
			
			// ASSERTS
			assertEquals(userFollowersCountDTO.getFollowers_count(),
			             service.getFollowersCount(1).getFollowers_count());
			
		}
	}
	
}