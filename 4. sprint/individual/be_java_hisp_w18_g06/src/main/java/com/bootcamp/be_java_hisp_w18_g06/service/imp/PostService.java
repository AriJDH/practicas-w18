package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.PromoPost;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.EmptyException;

import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IPostService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

	@Autowired
	private IUserRepository userRepository;

	// Mapeo -> No modificar por el momento!
	ObjectMapper mapper = JsonMapper.builder()
					.findAndAddModules()
					.build();
    @Override
    public void savePost(PostDTO postDTO) {
        userRepository.createPost(mapper.convertValue(postDTO, Post.class));
    }

	@Override
	public void savePromoPost(PostDTO postDTO) {
		userRepository.createPromoPost(mapper.convertValue(postDTO, PromoPost.class));
	}

	// US006
	@Override
	public List<PostDTO> findAllPostsByUser(int id) {

		User user = userRepository
						.findUserById(id)
						.orElseThrow(() -> new BadRequestException("The user id" + id
										+ " does not exist"));

		List<Post> postsSeller = getPosts(user)
						.orElseThrow(() -> new EmptyException("User does not follow Sellers"));

		List<Post> postsOrder = sortByDate(postsSeller)
						.orElseThrow(() -> new EmptyException("There are no posts to sort"));

		List<Post> postsFilter = filterLastTwoWeeks(postsOrder)
						.orElseThrow(() -> new EmptyException("There are no posts to sort in the last two weeks"));

		return postsFilter
						.stream()
						.map(this::mapperDTO)
						.collect(Collectors.toList());
	}
	@Override
	public List<PostDTO> sortedByAscAndDesc(int id, String order) {
		User user = userRepository
				.findUserById(id)
				.orElseThrow(() -> new BadRequestException("The user id" + id
						+ "does not exist"));
		List<Post> postsSeller = getPosts(user)
				.orElseThrow(() -> new EmptyException("User does not follow Sellers"));

		if (order.equals("date_asc")){
			return mapperListDto(sortByDate(postsSeller)
					.orElseThrow(() -> new EmptyException("There are no posts to sort")));
		}
		if (order.equals("date_desc")){
			return mapperListDto(sortByDateDesc(postsSeller)
					.orElseThrow(() -> new EmptyException("There are no posts to sort")));
		}else {
			throw new BadRequestException("Wrong order");
		}

	}

	// Métodos auxiliares
	private Optional<List<Post>> sortByDate(List<Post> posts) {
		return Optional.of(
						posts.stream()
										.sorted(Comparator
																		.comparing(Post::getDate)
														//.reversed()
										)
										.collect(Collectors.toList()));
	}

	private Optional<List<Post>> filterLastTwoWeeks(List<Post> posts) {

		return Optional.of(posts.stream()
						.filter(post -> Period.between(post.getDate(), LocalDate.now())
										.getDays() <= 14)
						.collect(Collectors.toList()));

	}

	private Optional<List<Post>> getPosts(User user) {
		List<Post> postList = new ArrayList<>();
		List<User> users = Optional.ofNullable(user.getFollowed())
						.orElseThrow(()-> new EmptyException("User does not follow Sellers"));

		user.getFollowed()
						.forEach(u -> postList.addAll(u.getPosts()));
		if (postList.size() == 0)
			return Optional.empty();
		return Optional.of(postList);
	}

	private PostDTO mapperDTO(Post post) {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.convertValue(post, PostDTO.class);
	}
	private List<PostDTO> mapperListDto(List<Post>posts){
		return posts.stream()
				.map(post -> mapperDTO(post))
				.collect(Collectors.toList());
	}
	private Optional<List<Post>> sortByDateDesc(List<Post> posts) {
		return Optional.of(
				posts.stream()
						.sorted(Comparator
								.comparing(Post::getDate)
								.reversed()
						)
						.collect(Collectors.toList()));
	}

}
