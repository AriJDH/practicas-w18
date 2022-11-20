package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.FollowerListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PromoPostCountDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.UserDTORes;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.PromoPost;
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

    @Override
    public void publishPromoPost(PromoPostDTOReq promoPostDTOReq) {
        if (promoPostDTOReq.isHas_promo()){
            PromoPost promoPost = Mapper.createObjectMapper().convertValue(promoPostDTOReq,PromoPost.class);
            postRepository.createPromoPost(promoPost);
        }
        else throw new BadRequestException("This product is not in promo");
    }

    @Override
    public PromoPostCountDTORes getPromoPostCount(Integer user_id) {
        if (validateSeller(user_id)){
            return promoPostCountBySeller(user_id);
        }
        else
            throw new BadRequestException("The user_id not exist");
    }

    private PromoPostCountDTORes promoPostCountBySeller(Integer user_id){
        Integer countPromoPost=getCountPromoPostBySeller(user_id);
        return generateSellerWithCountPosts(user_id,countPromoPost);
    }
    private PromoPostCountDTORes generateSellerWithCountPosts(Integer user_id, Integer countPosts){
        return new PromoPostCountDTORes(user_id, sellerRepository.findById(user_id).getUser_name(),countPosts);
    }

    private Integer getCountPromoPostBySeller(Integer user_id){
        List<PromoPost> promoPosts = postRepository.findAllPromoPost();
        return filterPromoPostBySeller(user_id, promoPosts);
    }

    private Integer filterPromoPostBySeller(Integer user_id, List<PromoPost> promoPosts){
        return promoPosts.stream().
                filter(promoPost -> promoPost.getUser_id().equals(user_id) && promoPost.isHas_promo())
                        .collect(Collectors.toList())
                .size();
    }
}
