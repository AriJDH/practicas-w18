package com.meli.be_java_hisp_w18_g9_camacho_ovalle.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PromoPostListByUserResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PromoProductsCountResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Post;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IProductRepository;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    // ? =============== Attributes =============== ?

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final ObjectMapper mapper;

    // ? =============== Methods =============== ?

    /**
     * Create a new post
     * @param postDtoRequest post to create
     */
    @Override
    public void addPost(PostDtoRequest postDtoRequest) {

        Post post = mapper.convertValue(postDtoRequest, Post.class);

        User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", post.getUserId())));

        if (Stream.of(post.getCategory(), post.getProduct(), post.getPrice(), post.getUserId()).anyMatch(Objects::isNull)) {
            throw new BadRequestException("All fields are required");
        }

        if (user.getProducts().stream().noneMatch(product -> product.getProductId().equals(post.getProduct().getProductId()))) {
            throw new BadRequestException("Product not associated with user");
        }

        postRepository.addPost(post);

        if (user.getProducts() == null) {
            user.setProducts(List.of(post.getProduct()));
        } else {
            user.getProducts().add(post.getProduct());
        }

        userRepository.update(user);

    }

    // * ===============

    /**
     * Get all posts
     *
     * @return list of posts
     */
    @Override
    public List<PostDtoResponse> findAll() {

        List<Post> postDtoResponseList = postRepository.findAll();

        return postDtoResponseList.stream()
                .map(post -> new PostDtoResponse(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice()))
                .collect(Collectors.toList());

    }

    // * ===============

    /**
     * Find a post by user id
     *
     * @param userId user id
     * @return PostListByFollowedResponse (post list by followed users)
     */
    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserId(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        PostListByFollowedResponse postListByFollowedResponse = new PostListByFollowedResponse();
        postListByFollowedResponse.setUserId(userId);
        List<PostDtoRequest> postDtoRequestList = new ArrayList<>();


        for (User userSeller : user.getFollowed()) {
            postDtoRequestList.addAll(postRepository.findAllById(userSeller.getUserId()).stream()
                    .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)) && post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                    .map(post -> mapper.convertValue(post, PostDtoRequest.class))
                    .sorted(Comparator.comparingInt(c -> c.getProduct().getProductId()))
                    .collect(Collectors.toList()));
        }

        postListByFollowedResponse.setPosts(postDtoRequestList);

        return postListByFollowedResponse;

    }

    // * ===============

    /**
     * Find a post by user id
     *
     * @param userId user id
     * @return PostListByFollowedResponse (post list by followed users) in order by date asc
     */
    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateAsc(Integer userId) {

        PostListByFollowedResponse postListByFollowedResponse = findPostsByFollowedAndUserId(userId);
        postListByFollowedResponse.getPosts().sort(Comparator.comparing(PostDtoRequest::getDate));
        return postListByFollowedResponse;

    }

    // * ===============

    /**
     * Find a post by user id
     *
     * @param userId user id
     * @return PostListByFollowedResponse (post list by followed users) in order by date desc
     */
    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateDesc(Integer userId) {

        PostListByFollowedResponse postListByFollowedResponse = findPostsByFollowedAndUserId(userId);
        postListByFollowedResponse.getPosts().sort(Comparator.comparing(PostDtoRequest::getDate).reversed());
        return postListByFollowedResponse;

    }

    // * ===============

    /**
     * Save a new promo post
     * @param promoPostRequest promo post to save
     * @return PromoPostResponse (promo post entity)
     */
    @Override
    public PromoPostRequest savePromo(PromoPostRequest promoPostRequest) {

        if(Stream.of(promoPostRequest.getUserId(), promoPostRequest.getProduct(), promoPostRequest.getCategory(), promoPostRequest.getPrice(), promoPostRequest.getDiscount()).anyMatch(Objects::isNull)) {
            throw new BadRequestException("All fields are required");
        }

        User user = userRepository.findById(promoPostRequest.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", promoPostRequest.getUserId())));

        if(user.getProducts().stream().noneMatch(product -> product.getProductId().equals(promoPostRequest.getProduct().getProductId()))){
            throw new BadRequestException("Product not associated with user");
        }

        Post post = mapper.convertValue(promoPostRequest, Post.class);

        post.setDate(LocalDate.now());
        post.setHasPromo(true);

        postRepository.addPost(post);

        return mapper.convertValue(postRepository.findById(post.getPostId()), PromoPostRequest.class);

    }

    // * ===============

    /**
     * Return a user info and counts promo posts published
     * @param userId user id to search
     * @return UserPromoCountResponse (user info and counts promo posts published)
     */
    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {

        PromoPostListByUserResponse promoPostListByUserResponse = findPromoByUserId(userId);

        return PromoProductsCountResponse.builder()
                .userId(userId)
                .userName(promoPostListByUserResponse.getUserName())
                .promoProductsCount(promoPostListByUserResponse.getPosts().size())
                .build();

    }

    // * ===============

    /**
     * Return a list of promo posts by user id
     * @param userId user id to search
     * @return PromoPostListByUserResponse (list of promo posts by user id)
     */
    @Override
    public PromoPostListByUserResponse findPromoByUserId(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        if(user.getProducts().isEmpty()){
            throw new BadRequestException(String.format("The user with the ID: %d you are looking for is not a seller", userId));
        }

        List<Post> promoPostById = postRepository.findAllById(userId).stream()
                .filter(Post::getHasPromo).collect(Collectors.toList());

        return PromoPostListByUserResponse.builder()
                .userId(userId)
                .userName(user.getUserName())
                .posts(mapper.convertValue(promoPostById, new TypeReference<List<PromoPostRequest>>(){}))
                .build();

    }

    // * ===============


}
