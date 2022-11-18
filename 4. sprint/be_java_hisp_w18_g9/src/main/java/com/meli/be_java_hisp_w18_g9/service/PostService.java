package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.core.type.TypeReference;
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
        if(Stream.of(post.getCategory(),post.getProduct(), post.getPrice(), post.getUserId()).anyMatch(Objects::isNull)){
            throw new BadRequestException("All fields are required");
        }
        User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", post.getUserId())));
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

    // * ===============

    @Override
    public void savePromo(PromoPostRequest promoPostRequest) {
        Post post = mapper.convertValue(promoPostRequest, Post.class);
        if(Stream.of(post.getUserId(), post.getDate(),post.getProduct(),post.getCategory(), post.getPrice(), post.getHasPromo(),post.getDiscount()).anyMatch(Objects::isNull)){
            throw  new BadRequestException("All fields are required");
        }
        User user = userRepository.findById(post.getUserId()).orElseThrow(()->new BadRequestException("User with id not exist"));
        List<Post> postList = postRepository.findAllByUserId(user.getUserId()).stream().collect(Collectors.toList());
        if(postList.isEmpty())
        {
            throw new NotFoundException(String.format("No post associated with id found " ,user.getUserId()));
        }
        postRepository.addPost(post);

    }

    // * ===============

    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {
            User users = userRepository.findById(userId).orElseThrow(()->new NotFoundException("User with id not found"));
            List<Post> post = postRepository.findAllByUserId(userId).stream().filter(Post::getHasPromo).collect(Collectors.toList());
            return PromoProductsCountResponse.builder().userId(userId).userName(users.getUserName()).promoProductsCount(post.size()).build();
    }

    // * ===============

    @Override
    public PromoPostListByUserResponse findPromoByUserId(Integer userId) {
        User users = userRepository.findById(userId).orElseThrow(()->new NotFoundException("User with id not found"));
        List<Post> postList = postRepository.findAllByUserId(userId).stream().filter(Post::getHasPromo).collect(Collectors.toList());
        return PromoPostListByUserResponse.builder().userId(userId).userName(users.getUserName()).posts(mapper.convertValue(postList, new TypeReference<List<PromoPostRequest>>() {})).build();
    }

    // * ===============


}
