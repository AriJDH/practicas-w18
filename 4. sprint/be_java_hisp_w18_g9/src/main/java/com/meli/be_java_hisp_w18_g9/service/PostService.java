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
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9.repository.IProductRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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
    private final IProductRepository iProductRepository;
    private final ObjectMapper mapper;

    // ? =============== Methods =============== ?

    @Override
    public void addPost(PostDtoRequest postDtoRequest) {
        Post post = mapper.convertValue(postDtoRequest, Post.class);
        if(Stream.of(post.getCategory(),post.getProduct(), post.getDate(), post.getPrice(), post.getUserId()).anyMatch(Objects::isNull)){
            throw  new BadRequestException("");
        }
        iProductRepository.save(post.getProduct());
        postRepository.addPost(post);
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
    public List<PostListByFollowedResponse> findPostsByFollowedAndUserId(Integer userId) {
        return null;
    }

    // * ===============

    @Override
    public List<PostListByFollowedResponse> findPostsByFollowedAndUserIdOrderByDateAsc(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        return user.getFollowed().stream()
                .map(followed -> PostListByFollowedResponse.builder()
                        .userId(followed.getUserId())
                        .posts(postRepository.findAllByUserId(followed.getUserId()).stream()
                                .map(post -> mapper.convertValue(post, PostDtoRequest.class))
                                .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)) && post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                                .sorted(Comparator.comparing(PostDtoRequest::getDate))
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

    }

    // * ===============

    @Override
    public List<PostListByFollowedResponse> findPostsByFollowedAndUserIdOrderByDateDesc(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with id %d not found", userId)));

        return user.getFollowed().stream()
                .map(followed -> PostListByFollowedResponse.builder()
                        .userId(followed.getUserId())
                        .posts(postRepository.findAllByUserId(followed.getUserId()).stream()
                                .map(post -> mapper.convertValue(post, PostDtoRequest.class))
                                .filter(post -> post.getDate().isBefore(LocalDate.now().plusDays(1)) && post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                                .sorted(Comparator.comparing(PostDtoRequest::getDate).reversed())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

    }

    // * ===============

    @Override
    public PromoPostRequest savePromo(PromoPostRequest promoPostRequest) {
        return null;
    }

    // * ===============

    @Override
    public PromoProductsCountResponse countPromoByUserId(Integer userId) {
        return null;
    }

    // * ===============

    @Override
    public List<PromoPostListByUserResponse> findPromoByUserId(Integer userId) {
        return null;
    }

    // * ===============


}
