package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.request.PostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.dto.respose.*;
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
    @Override
    public void publishPost(PromoPostDTOReq postDTOReq) {
        Post post= Mapper.createObjectMapper().convertValue(postDTOReq, Post.class);
        postRepository.createPost(post);
        UserSeller seller = sellerRepository.findById(postDTOReq.getUser_id());
        seller.getPosts().add(post);
    }

    @Override
    public void publishPromoPost(PromoPostDTOReq postDTOReq) {
       //if (!postDTOReq.getHas_promo()) throw new BadRequestException("The product is not on promotion");
        PostPromo post= Mapper.createObjectMapper().convertValue(postDTOReq, PostPromo.class);
        postRepository.createPromoPost(post);
    }

    @Override
    public PromoPostCountDTORes promoPostCount(Integer userId) {
        int cont;
        List<PostPromo> promoPost = postRepository.findAllPromoPosts();
        List<PostPromo> promoPostByUser = promoPost.stream()
                .filter(pp -> pp.getUser_id().equals(userId))
                .collect(Collectors.toList());

        if (promoPostByUser.isEmpty()){
            throw new BadRequestException("this user has no posts");
        }

        String userName = sellerRepository.findById(userId).getUser_name();
        cont = (int) promoPostByUser.stream().filter(PostPromo::getHas_promo).count();

        return new PromoPostCountDTORes(userId, userName, cont);
    }

    @Override
    public PromoPostListoDTORes promoPostList(Integer userId) {
        List<PostPromo> promoPost = postRepository.findAllPromoPosts();
        List<PostPromo> promoPostByUser = promoPost.stream()
                .filter(pp -> pp.getUser_id().equals(userId) && pp.getHas_promo())
                .collect(Collectors.toList());

        if (promoPostByUser.isEmpty()){
            throw new BadRequestException("this user has no posts");
        }
        String userName = sellerRepository.findById(userId).getUser_name();

        return new PromoPostListoDTORes(userId, userName, promoPostByUser);
    }

    @Override
    public PromoPostListoDTORes productsToPromotion(Integer userId) {
        List<PostPromo> promoPost = postRepository.findAllPromoPosts();
        List<PostPromo> promoPostByUser = promoPost.stream()
                .filter(pp -> pp.getUser_id().equals(userId) && !pp.getHas_promo())
                .collect(Collectors.toList());

        if (promoPostByUser.isEmpty()){
            throw new BadRequestException("this user has no posts");
        }

        promoPostByUser.stream()
                .forEach(pp -> pp.setHas_promo(true));

        String userName = sellerRepository.findById(userId).getUser_name();

        return new PromoPostListoDTORes(userId, userName, promoPostByUser);
    }


}
