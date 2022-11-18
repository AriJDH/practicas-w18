package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.PostwithPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia.be_java_hisp_w18_g08.exception.BadRequestException;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia.be_java_hisp_w18_g08.repository.IPostRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia.be_java_hisp_w18_g08.util.OrderDateAsc;
import com.socialmedia.be_java_hisp_w18_g08.util.OrderDateDesc;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
            throw new NotFoundUserException("The date could not be ordered ");
        }
        return list;
    }

    @Override
    public void create(PostDtoReq postDTOReq) {
        Seller seller = userRepository.findSellerById(postDTOReq.getUser_id());
        if (seller == null) {
            throw new BadRequestException("The post was not created. No user with id " + postDTOReq.getUser_id());
        } else {
            Post post = new Post(postId, postDTOReq.getUser_id(), postDTOReq.getProduct(), postDTOReq.getCategory(),
                    postDTOReq.getPrice(), postDTOReq.getDate());
            postRepository.save(post);
            userRepository.createPost(post, postDTOReq.getUser_id());
            postId++;
        }
    }

    @Override
    public void createPostWithPromo(PostwithPromoDtoReq postwithPromoDtoReq) {
        Seller seller = userRepository.findSellerById(postwithPromoDtoReq.getUser_id());
        if (seller == null) {
            throw new BadRequestException("The post was not created. No user with id " + postwithPromoDtoReq.getUser_id());
        } else {
            Post post = new Post(postId, postwithPromoDtoReq.getUser_id(), postwithPromoDtoReq.getProduct(), postwithPromoDtoReq.getCategory(),
                    postwithPromoDtoReq.getPrice(), postwithPromoDtoReq.getDate(), postwithPromoDtoReq.getHas_promo(),postwithPromoDtoReq.getDiscount());
            postRepository.save(post);
            userRepository.createPost(post, postwithPromoDtoReq.getUser_id());
            postId++;
        }
    }

    @Override
    public PostDtoRes getPostSellerListByUserId(Integer userId, String order) {
        List<Seller> followed = userService.getFollowedByUserId(userId);

        PostDtoRes postDtoRes = new PostDtoRes();
        LocalDate date = LocalDate.now();
        postDtoRes.setUser_id(userId);
        List<PostDto> filtrados = new ArrayList<>();

        for (Seller s : followed) {
            for(Post p: s.getPosts()){
                if(p.getDate().isAfter((date.minusDays(115)))){
                    PostDto aux = new PostDto(p.getPost_id(), p.getUser_id(), p.getProduct(),
                            p.getCategory(),p.getPrice(), p.getDate());
                    filtrados.add(aux);
                }
            }
            if (!filtrados.isEmpty()){
                postDtoRes.setPosts(changeOrder(filtrados,order));
            }
        }
        if (followed.isEmpty()) {
            throw new NotFoundUserException("User whith id: " + userId + " sellers post not found ");
        }
        return postDtoRes;
    }

}
