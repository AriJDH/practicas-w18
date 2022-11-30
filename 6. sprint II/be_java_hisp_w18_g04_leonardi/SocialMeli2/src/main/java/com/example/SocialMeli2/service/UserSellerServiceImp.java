package com.example.SocialMeli2.service;


import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.request.ProductDTOReq;
import com.example.SocialMeli2.dto.respose.*;
import com.example.SocialMeli2.entity.Post;
import com.example.SocialMeli2.entity.Product;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.BadRequestException;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IPostRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;
import com.example.SocialMeli2.util.Mapper;
import com.example.SocialMeli2.util.Sorter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserSellerServiceImp implements IUserSellerService {
    private final IUserSellerRepository sellerRepository;
    private final IPostRepository postRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository, IPostRepository postRepository) {
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
    }


    @Override
    public FollowerCountDTORes followersCount(Integer userId) {
        UserSeller seller = getSeller(userId);
        return new FollowerCountDTORes(seller.getUser_id(), seller.getUser_name(), seller.getFollowers().size());
    }

    @Override
    public FollowerListDTORes getFollowers(Integer userId, String order) {
        UserSeller seller = getSeller(userId);
        List<UserBuyer> buyers = seller.getFollowers();
        List<UserDTORes> userDTOResList = buyers.stream().map(UserDTORes::new).collect(Collectors.toList());

        if (!order.equals("invalid"))
            Sorter.sortedByName(userDTOResList, order);
        else
            throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");

        return new FollowerListDTORes(seller.getUser_id(), seller.getUser_name(), userDTOResList);
    }

    @Override
    public PostDTORes publishPost(PostDTOReq postDTOReq) {
        UserSeller seller = getSeller(postDTOReq.getUser_id());
        Post post = Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
        postRepository.createPost(post);
        seller.getPosts().add(post);
        return new PostDTORes(postDTOReq.getUser_id(), post.getPost_id(), postDTOReq.getDate(), new ProductDTORes(post.getProduct()), postDTOReq.getCategory(), postDTOReq.getPrice());
    }

    private UserSeller getSeller(Integer id) {
        Optional<UserSeller> optionalUserSeller = sellerRepository.findById(id);
        UserSeller seller = optionalUserSeller.orElseThrow(() -> new UserNotFoundException("The buyer " + id + " doesn't exist"));
        return seller;
    }
}
