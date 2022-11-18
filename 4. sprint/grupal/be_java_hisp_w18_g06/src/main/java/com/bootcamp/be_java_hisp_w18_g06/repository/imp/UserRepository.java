package com.bootcamp.be_java_hisp_w18_g06.repository.imp;

import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.EmptyException;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
	
	// Base de datos
	List<User> users = new ArrayList<>();

	List<Product> products = new ArrayList<>();
	List<Post> posts = new ArrayList<>();
	List<User> followed = new ArrayList<>();
	
	Product product1 = new Product(
					1,
					"Silla Gamer",
					"Gamer",
					"Racer",
					"Red & Black",
					"Special Edition"
	);
	
	Product product2 = new Product(
					2,
					"Headset RGB inalámbrico",
					"Gamer",
					"Racer",
					"Green with RGB",
					"Sin batería"
	);
	
	User user1 = new User(
					1,
					"usuario1"
	);
	
	User user2 = new User(
					2,
					"usuario2"
	);
	
	Post post1 = new Post(
					1,
					user1.getUser_id(),
					LocalDate.of(2022, 11, 10),
					product1,
					"120",
					2800.69
	);
	
	Post post2 = new Post(
					2,
					user1.getUser_id(),
					LocalDate.of(2021, 4, 29),
					product2,
					"100",
					15000.50
	);
	
	public void createDB() {
		products.add(product1);
		products.add(product2);
		posts.add(post1);
		posts.add(post2);
		users.add(user1);
		users.add(user2);
		addPostToUser();
	}
	
	public UserRepository() {
		createDB();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return users
						.stream()
						.filter(user -> user.getUser_id() == id)
						.findFirst();
	}

	@Override
	public Optional<User> findUserInList(List<User> list, int idUserInList) {
		if(list == null)
			return Optional.empty();

		return list
				.stream()
				.filter(user -> user.getUser_id() == idUserInList)
				.findFirst();
	}

	@Override
	public void createPost(Post post) {
		posts.add(post);
	}

	public void addPostToUser(){
		user1.setPosts(posts);
	}

	@Override
	public User getUser(int userId) {
		Optional<User> user = findUserById(userId);
		if (user.isEmpty()) {
			throw new NotFoundException("The user id: " + userId + " doesn't exists");
		}
		return user.get();
	}
}
