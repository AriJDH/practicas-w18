package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PostPromoDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.UserDTORes;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PostPromo;
import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import com.example.BE_java_hisp_w18_g04.exception.BadRequestException;
import com.example.BE_java_hisp_w18_g04.repository.IPostRepository;
import com.example.BE_java_hisp_w18_g04.repository.IUserSellerRepository;
import com.example.BE_java_hisp_w18_g04.util.Mapper;
import com.example.BE_java_hisp_w18_g04.util.Sorter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSellerServiceImp implements IUserSellerService{
    private final IUserSellerRepository sellerRepository;
    private final IPostRepository postRepository;

    public UserSellerServiceImp(IUserSellerRepository sellerRepository, IPostRepository postRepository) {
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
    }

    @Override
    public FollowerCountDTORes followersCount(Integer userId) {
        if(validateSeller(userId)) {
            UserSeller seller = sellerRepository.findById(userId);
            return new FollowerCountDTORes(seller.getUser_id(), seller.getUser_name(), seller.getFollowers().size());
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }
    private Boolean validateSeller(Integer id){
        Boolean valid = false;
        List<UserSeller> sellers = sellerRepository.findAll();
        for(UserSeller seller: sellers){
            if(seller.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;
    }
    @Override
    public FollowerListDTORes getFollowers(Integer userId, String order) {
        if(validateSeller(userId)) {
            UserSeller seller = sellerRepository.findById(userId);
            List<UserBuyer> buyers = seller.getFollowers();
            List<UserDTORes> userDTOResList = buyers.stream().map(buyer -> new UserDTORes(buyer)).collect(Collectors.toList());
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            return new FollowerListDTORes(seller.getUser_id(), seller.getUser_name(), userDTOResList);
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    @Override
    public void publishPost(PostDTOReq postDTOReq) {
        Post post= Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
        postRepository.createPost(post);
        UserSeller seller = sellerRepository.findById(postDTOReq.getUser_id());
            seller.getPosts().add(post);
    }

    public void publishPromoPost(PostPromoDTOReq postPromoDTOReq) {

        PostPromo postPromo= Mapper.createObjectMapper().convertValue(postPromoDTOReq, PostPromo.class);
        postRepository.createPostPromo(postPromo);
        UserSeller seller = sellerRepository.findById(postPromoDTOReq.getPost().getUser_id());
        seller.getPosts().add(postPromo);
    }

}
