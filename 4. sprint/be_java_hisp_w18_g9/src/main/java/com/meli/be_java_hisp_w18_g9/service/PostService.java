package com.meli.be_java_hisp_w18_g9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.*;
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

    // * ===============

    @Override
    public PromoPostRequest savePromo(PromoPostRequest promoPostRequest) {
        Post post = mapper.convertValue(promoPostRequest, Post.class);

        User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", post.getUserId())));

        if(Stream.of(post.getCategory(),post.getProduct(), post.getPrice(), post.getUserId(),post.getHasPromo(),post.getDiscount()).anyMatch(Objects::isNull)){
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
        return null;
    }
    // * ===============

    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {
        User userWf = userRepository.findById(userId).orElseThrow(() -> new BadRequestException(String.format("User with id %d doesn't exist", userId)));
        Long promoQ = postRepository.findAll()
                                         .stream()
                                         .filter(x->x.getUserId() == userId && x.getHasPromo())
                                         .count();

        return new PromoProductsCountResponse(userId,userWf.getUserName(), promoQ.intValue());
    }

    // * ===============

    @Override
    public PromoPostListByUserResponse findPromoByUserId(Integer userId) {
        User userWf = userRepository.findById(userId).orElseThrow(() -> new BadRequestException(String.format("User with id %d doesn't exist", userId)));
        List<PromoPostRequest> posts = postRepository.findAll()
                .stream()
                .filter(x->x.getUserId() == userId && x.getHasPromo())
                .map(x -> mapper.convertValue(x, PromoPostRequest.class))
                .collect(Collectors.toList());




        return new PromoPostListByUserResponse(userId,userWf.getUserName(),posts);
    }

    // * ===============


}
