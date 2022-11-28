package com.example.SocialMeli2.service;


import com.example.SocialMeli2.dto.request.PostDTOReq;
import com.example.SocialMeli2.dto.respose.FollowerCountDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;
import com.example.SocialMeli2.entity.Post;
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
        if (validateSeller(userId)) {
            UserSeller seller = sellerRepository.findById(userId);
            return new FollowerCountDTORes(seller.getUser_id(), seller.getUser_name(), seller.getFollowers().size());
        } else {
            throw new UserNotFoundException("The seller " + userId + " not exist");
        }
    }

    private Boolean validateSeller(Integer id) {
        Boolean valid = false;
        List<UserSeller> sellers = sellerRepository.findAll();
        for (UserSeller seller : sellers) {
            if (seller.getUser_id().equals(id)) {
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public FollowerListDTORes getFollowers(Integer userId, String order) {
        if (validateSeller(userId)) {
            UserSeller seller = sellerRepository.findById(userId);
            List<UserBuyer> buyers = seller.getFollowers();
            List<UserDTORes> userDTOResList = buyers.stream().map(buyer -> new UserDTORes(buyer)).collect(Collectors.toList());
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            return new FollowerListDTORes(seller.getUser_id(), seller.getUser_name(), userDTOResList);
        } else {
            throw new UserNotFoundException("The seller " + userId + " not exist");
        }
    }

    @Override
    public void publishPost(PostDTOReq postDTOReq) {
        if (validateSeller(postDTOReq.getUser_id())) {
            Post post = Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
            postRepository.createPost(post);
            UserSeller seller = sellerRepository.findById(postDTOReq.getUser_id());
            seller.getPosts().add(post);
        } else {
            throw new UserNotFoundException("The seller " + postDTOReq.getUser_id() + " not exist");
        }
    }
}
