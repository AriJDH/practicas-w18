package com.bootcamp.be_java_hisp_w18_g06.integrationTest;

import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.PostService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProductIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	// Para poder mockear el repositorio en el service:
	@MockBean
	IUserRepository userRepository;
	
	@Autowired
	PostService postService;
	
	// ----------------------------------------------------------- //
	
	@Test
	@DisplayName("T0009 - Get all products by user happy path =^.^=")
	void findAllProductsByUserOkTest() throws Exception {
		
		// MOCKS
		// Usuarios que vamos a usar
		User user1 = new User();
		user1.setUser_id(1);
		user1.setUser_name("user1");
		
		User user2 = new User();
		user2.setUser_id(2);
		user2.setUser_name("user2");
		
		User user3 = new User();
		user3.setUser_id(3);
		user3.setUser_name("user3");
		
		// Posts que vamos a usar
		List<Post> postList = new ArrayList<>();
		postList.add(new Post(1,
		                      LocalDate.of(2022, 11, 27),
		                      new Product(),
		                      "category",
		                      10.00));
		
		// Seteamos la lista de posts a cada usuario
		user1.setPosts(postList);
		user2.setPosts(postList);
		
		// Armamos una lista de sellers
		List<User> sellers = Arrays.asList(user1, user2);
		
		// Seteamos la lista de seguidos del usuario 3
		user3.setFollowed(sellers);
		
		// Cuando pedimos un usuario al repositorio devolvemos el usuario 3 que sigue a 1 y 2
		when(userRepository
						     .findUserById(3))
						.thenReturn(Optional.of(user3));
		
		MvcResult mvcResult = mockMvc
						.perform(
										
										get("/products/followed/3/list"))
						.andDo(print())
						.andExpect(status()
										           .isOk())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	@DisplayName("T0010 - Post save post happy path =^.^=")
	void savePostOkTest() {
	
	
	
	}
	
}
