package com.socialmedia.be_java_hisp_w18_Otero.service;

import com.socialmedia.be_java_hisp_w18_Otero.dto.PostDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PromoPostCountDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.RankingLikesDto;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Post;
import com.socialmedia.be_java_hisp_w18_Otero.exception.BadRequestException;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Seller;
import com.socialmedia.be_java_hisp_w18_Otero.exception.NotFoundException;
import com.socialmedia.be_java_hisp_w18_Otero.repository.IPostRepository;
import com.socialmedia.be_java_hisp_w18_Otero.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_Otero.repository.PostRepositoryImp;
import com.socialmedia.be_java_hisp_w18_Otero.repository.UserRepositoryImp;
import com.socialmedia.be_java_hisp_w18_Otero.util.OrderDateAsc;
import com.socialmedia.be_java_hisp_w18_Otero.util.OrderDateDesc;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService {

    private IPostRepository postRepository;
    private IUserRepository userRepository;
    private IUserService userService;

    public PostServiceImp(PostRepositoryImp postRepository, UserRepositoryImp userRepository,
                          UserServiceImp userService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    private Integer postId = 5;

    private List<PostDto> changeOrder(List<PostDto> list, String order) {

        Comparator<LocalDate> compareByDate;

        if (order == null || order.equals("date_desc")) {
            compareByDate = new OrderDateDesc();
            list.sort((l1, l2) -> compareByDate.compare(l1.getDate(), l2.getDate()));
            ;
        } else if (order.equals("date_asc")) {
            compareByDate = new OrderDateAsc();
            list.sort((l1, l2) -> compareByDate.compare(l1.getDate(), l2.getDate()));
        } else {
            throw new NotFoundException("The date could not be ordered ");
        }
        return list;
    }

    @Override
    public void createPost(PostDtoReq p) {
        Seller seller = userRepository.findSellerById(p.getUser_id());
        if (seller == null) {
            throw new BadRequestException("The post was not created. No user with id " + p.getUser_id());
        }
        Post post = new Post(postId, p.getUser_id(), p.getDate(), p.getProduct(), p.getCategory(), p.getPrice());
        postRepository.save(post);
        userRepository.createPost(post, p.getUser_id());
        postId++;
    }

    @Override
    public PostDtoRes getPostSellerListByUserId(Integer userId, String order) {
        List<Seller> followed = userService.getFollowedByUserId(userId);

        PostDtoRes postDtoRes = new PostDtoRes();
        LocalDate date = LocalDate.now();
        postDtoRes.setUser_id(userId);
        List<PostDto> filtrados = new ArrayList<>();

        for (Seller s : followed) {
            for (Post p : s.getPosts()) {
                if (p.getDate().isAfter((date.minusDays(15)))) {
                    System.out.println(p);
                    PostDto aux =
                            new PostDto(p.getPost_id(), p.getUser_id(), p.getProduct(), p.getCategory(), p.getPrice(),
                                    p.getDate(), p.getLikes());
                    filtrados.add(aux);
                }
            }
            if (!filtrados.isEmpty()) {
                postDtoRes.setPosts(changeOrder(filtrados, order));
            }
        }
        if (followed.isEmpty()) {
            throw new NotFoundException("User whith id: " + userId + " sellers post not found ");
        }
        return postDtoRes;
    }

    @Override
    public void createPromoPost(PostPromoDtoReq p) {
        Seller seller = userRepository.findSellerById(p.getUser_id());
        if (seller == null) {
            throw new BadRequestException("The post was not created. No user with id " + p.getUser_id());
        } else {
            Post post =
                    new Post(postId, p.getUser_id(), p.getDate(), p.getProduct(), p.getCategory(), p.getPrice(),
                            p.isHas_promo(), p.getDiscount());
            postRepository.save(post);
            userRepository.createPost(post, p.getUser_id());
            postId++;
        }
    }

    @Override
    public PromoPostCountDto getPromoPostCountBySeller(Integer userId) {
        Seller seller = userRepository.findSellerById(userId);
        if (seller == null) throw new NotFoundException("There is no user with the ID " + userId);
        int count = seller.getPosts().stream().filter(post -> post.isHas_promo()).collect(Collectors.toList()).size();
        PromoPostCountDto response = new PromoPostCountDto(userId, seller.getUser_name(), count);

        return response;
    }

    @Override
    public void AddlikeToPost(Integer post_id) {
        Post post = postRepository.getById(post_id);
        if (post == null) throw new NotFoundException("There is no post with the ID " + post_id);
        post.addLike();
    }

    @Override
    public RankingLikesDto getRankingLikes(String order) {
        List<Post> posts = postRepository.getAll();
        Comparator<Post> compareBylikes = Comparator.comparing(Post::getLikes);
        if (order != null) {
            Collections.sort(posts, compareBylikes);
        } else {
            Collections.sort(posts, compareBylikes.reversed());
        }

        return new RankingLikesDto(createPostDtoList(posts));
    }

    private List<PostDto> createPostDtoList(List<Post> list) {
        List<PostDto> listAux = new ArrayList<>();
        for (Post p : list) {
            PostDto aux = new PostDto(p.getPost_id(), p.getUser_id(), p.getProduct(), p.getCategory(), p.getPrice(),
                    p.getDate(), p.getLikes());
            listAux.add(aux);
        }
        return listAux;
    }
}
