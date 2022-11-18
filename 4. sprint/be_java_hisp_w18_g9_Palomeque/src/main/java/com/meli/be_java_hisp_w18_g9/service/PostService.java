package com.meli.be_java_hisp_w18_g9.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.BadRequestException;
import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PromoPostRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.*;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        for (User userSeller : user.getFollowed()) {
            postDtoRequestList.addAll(postRepository.findAllByUserId(userSeller.getUserId()).stream()
                    .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)) && post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                    .map(post -> mapper.convertValue(post, PostDtoRequest.class))
                    .sorted(Comparator.comparingInt(c -> c.getProduct().getProductId()))
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
    public HttpStatus savePromo(PromoPostRequest promoPostRequest) {

        if (Stream.of(promoPostRequest.getCategory(), promoPostRequest.getProduct(),
                promoPostRequest.getPrice(), promoPostRequest.getUserId(),
                promoPostRequest.getHasPromo(), promoPostRequest.getDiscount()).anyMatch(Objects::isNull)) {
            throw new BadRequestException("All fields are required");
        }

        Post promo_post = mapper.convertValue(promoPostRequest, Post.class);
        User user = userRepository.findById(promo_post.getUserId()).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", promo_post.getUserId())));

        postRepository.addPost(promo_post);

        if (user.getProducts() == null) {
            user.setProducts(List.of(promo_post.getProduct()));
        } else {
            user.getProducts().add(promo_post.getProduct());
        }

        userRepository.update(user);

        return HttpStatus.OK;
    }

    // * ===============

    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new BadRequestException("User with id:" + userId + " doesn't exist"));

        if (user.getProducts().isEmpty())
            throw new BadRequestException("User isn't a seller");

        return new PromoProductsCountResponse(user.getUserId(), user.getUserName(), postRepository.findAllPromoByUserId(userId).size());
    }

    // * ===============

    @Override
    public PromoPostListByUserResponse findPromoByUserId(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        return new PromoPostListByUserResponse(
                userId,
                user.getUserName(),
                postRepository.findAllPromoByUserId(userId).stream()
                        .map(post -> mapper.convertValue(post, PromoPostRequest.class))
                        .sorted(Comparator.comparingInt(c -> c.getProduct().getProductId()))
                        .collect(Collectors.toList()));
    }

    @Override
    public HttpStatus disablePromo(Integer promoId) {
        Post post_promo =  postRepository.findAllPromosById(promoId);

        if(post_promo == null)
            throw new BadRequestException("Promo with id "+promoId+" not found");

        post_promo.setHasPromo(false);

        postRepository.update(post_promo);

        return HttpStatus.OK;
    }

    // * ===============


}
