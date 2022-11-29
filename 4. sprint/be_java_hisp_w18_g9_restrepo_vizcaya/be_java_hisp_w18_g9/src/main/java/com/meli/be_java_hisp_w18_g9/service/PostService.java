package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoPostListByUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PromoProductsCountResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9.repository.IProductRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{

    // ? =============== Attributes =============== ?

    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final ObjectMapper mapper;

    // ? =============== Methods =============== ?

    @Override
    public void addPost(PostDtoRequest postDtoRequest) {

        Post post = mapper.convertValue(postDtoRequest, Post.class);

        User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", post.getUserId())));

        if(Stream.of(post.getCategory(),post.getProduct(), post.getPrice(), post.getUserId()).anyMatch(Objects::isNull)){
            throw new BadRequestException("All fields are required");
        }

        if(user.getProducts().stream().noneMatch(product -> product.getProductId().equals(post.getProduct().getProductId()))){
            throw new BadRequestException("Product not associated with user");
        }

        postRepository.addPost(post);

        if(user.getProducts() == null){
            user.setProducts(List.of(post.getProduct()));
        }else{
            user.getProducts().add(post.getProduct());
        }

        userRepository.update(user);

    }

    // * ===============

    @Override
    public List<PostDtoResponse> findAll() {

        List<Post> postDtoResponseList = postRepository.findAll();

        return postDtoResponseList.stream()
                .map(post -> new PostDtoResponse(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice()))
                .collect(Collectors.toList());

    }

    // * ===============

    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserId(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        PostListByFollowedResponse postListByFollowedResponse = new PostListByFollowedResponse();
        postListByFollowedResponse.setUserId(userId);
        List<PostDtoRequest> postDtoRequestList = new ArrayList<>();


        for (User userSeller: user.getFollowed()) {
            postDtoRequestList.addAll(postRepository.findAllByUserId(userSeller.getUserId()).stream()
                    .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)) && post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                    .map(post -> mapper.convertValue(post, PostDtoRequest.class))
                    .sorted(Comparator.comparingInt(c->c.getProduct().getProductId()))
                    .collect(Collectors.toList()));
        }

        postListByFollowedResponse.setPosts(postDtoRequestList);

        return postListByFollowedResponse;

    }

    // * ===============

    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateAsc(Integer userId) {

        PostListByFollowedResponse postListByFollowedResponse = findPostsByFollowedAndUserId(userId);
        postListByFollowedResponse.getPosts().sort(Comparator.comparing(PostDtoRequest::getDate));
        return postListByFollowedResponse;

    }

    // * ===============

    @Override
    public PostListByFollowedResponse findPostsByFollowedAndUserIdOrderByDateDesc(Integer userId) {

        PostListByFollowedResponse postListByFollowedResponse = findPostsByFollowedAndUserId(userId);
        postListByFollowedResponse.getPosts().sort(Comparator.comparing(PostDtoRequest::getDate).reversed());
        return postListByFollowedResponse;

    }

    // US 10 - publication of a new product in promotion

    @Override
    public PromoPostRequest savePromo(PromoPostRequest promoPostRequest) {

        //Create exception for cases where the object is null
        if(Stream.of(promoPostRequest.getUserId(), promoPostRequest.getProduct(), promoPostRequest.getCategory(), promoPostRequest.getPrice(), promoPostRequest.getDiscount()).anyMatch(Objects::isNull)) {
            throw new BadRequestException("All fields are required");
        }

        //Create user with userID for search in the repository and throw exception as appropriate
        User user = userRepository.findById(promoPostRequest.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", promoPostRequest.getUserId())));

        //Search the product in the users for asociate
        if(user.getProducts().stream().noneMatch(product -> product.getProductId().equals(promoPostRequest.getProduct().getProductId()))){
            throw new BadRequestException("Product not associated with user");
        }
        //Mapping
        Post post = mapper.convertValue(promoPostRequest, Post.class);

        post.setDate(LocalDate.now());
        post.setHasPromo(true);

        //Add new post in the repository
        postRepository.addPost(post);


        return mapper.convertValue(postRepository.findById(post.getPostId()), PromoPostRequest.class);


    }

    // US 11 - quantity of products in promotion of a certain seller
    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {

        User users = userRepository.findById(userId).orElseThrow(()->new NotFoundException("User with id not found"));
        List<Post> post = postRepository.findAllByUserId(userId).stream().filter(Post::getHasPromo).collect(Collectors.toList());
        return PromoProductsCountResponse.builder().userId(userId).userName(users.getUserName()).promoProductsCount(post.size()).build();

    }

    // * US 12 - list of all the products in promotion of certain seller

    @Override
    public PromoPostListByUserResponse findPromoByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        List<Post> promoPostById = postRepository.findAllByUserId(userId).stream()
                .filter(Post::getHasPromo).collect(Collectors.toList());

        return PromoPostListByUserResponse.builder()
                .userId(userId)
                .userName(user.getUserName())
                .posts(mapper.convertValue(promoPostById, new TypeReference<List<PromoPostRequest>>(){}))
                .build();
    }

    // * ===============


}
