package com.example.BE_java_hisp_w18_g04.service;


import com.example.BE_java_hisp_w18_g04.dto.respose.*;
import com.example.BE_java_hisp_w18_g04.entity.Post;
import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;
import com.example.BE_java_hisp_w18_g04.exception.BadRequestException;
import com.example.BE_java_hisp_w18_g04.repository.IUserBuyerRepository;
import com.example.BE_java_hisp_w18_g04.repository.IUserSellerRepository;
import com.example.BE_java_hisp_w18_g04.util.Sorter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserBuyerServiceImp implements IUserBuyerService{
    private final IUserBuyerRepository userBuyerRepository;
    private final IUserSellerRepository userSellerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository, IUserSellerRepository userSellerRepository) {
        this.userBuyerRepository = userBuyerRepository;
        this.userSellerRepository = userSellerRepository;
    }

    private Boolean validateBuyer(Integer id){
        Boolean valid = false;
        List<UserBuyer> buyers = userBuyerRepository.findAll();
        for(UserBuyer buyer: buyers){
            if(buyer.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;
    }
    private Boolean validateSeller(Integer id){
        Boolean valid = false;
        List<UserSeller> sellers = userSellerRepository.findAll();
        for(UserSeller seller: sellers){
            if(seller.getUser_id().equals(id)){
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
            if(validateBuyer(userId) && validateSeller(userIdToFollow)) {
                UserBuyer buyer = userBuyerRepository.findById(userId);
                UserSeller seller = userSellerRepository.findById(userIdToFollow);
                if (!(buyer.getFollowed().contains(seller)) && !(seller.getFollowers().contains(buyer))) {
                    buyer.getFollowed().add(seller);
                    seller.getFollowers().add(buyer);
                } else {
                    throw new BadRequestException("The user " + userIdToFollow + " is already in your follow list");
                }
            } else{
                throw new BadRequestException("The user_id not exist");
            }
        }


    @Override
    public FollowedListDTORes getFollowed(Integer userId, String order) {
        if(validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> sellers = buyer.getFollowed();
            List<UserDTORes> userDTOResList = sellers.stream().map(e -> new UserDTORes(e)).collect(Collectors.toList());
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            return new FollowedListDTORes(buyer.getUser_id(), buyer.getUser_name(), userDTOResList);
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        if(validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> followed = buyer.getFollowed();
            List<PostDTORes> postsFollowed = new ArrayList<>();
            getPostListSeller(followed, postsFollowed);

            List<PostDTORes> filterList = filterPostByDate(postsFollowed);

            if (!order.equals("invalid"))
                Sorter.sortByDate(filterList, order);
            return new PostFollowedByDateDTORes(buyer.getUser_id(), filterList);
        } else {
            throw new BadRequestException("The user_id not exist");
        }
    }

    private List<PostDTORes> filterPostByDate(List<PostDTORes> postDTOResList){
        return postDTOResList.stream().
                filter(postDTORes->postDTORes.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());
    }
    private void getPostListSeller(List<UserSeller> followed, List<PostDTORes> postsFollowed){
        for (UserSeller seller: followed) {
            for ( Post post: seller.getPosts()) {
                postsFollowed.add(new PostDTORes(seller.getUser_id(),post));
            }
        }
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        if(validateBuyer(userId) && validateSeller(userIdToUnfollow)) {
        UserBuyer buyer = userBuyerRepository.findById(userId);
        UserSeller seller = userSellerRepository.findById(userIdToUnfollow);
        if (buyer.getFollowed().contains(seller) && (seller.getFollowers().contains(buyer))) {
            buyer.getFollowed().remove(seller);
            seller.getFollowers().remove(buyer);
        } else {
            throw new BadRequestException("The user "+userIdToUnfollow+" is not in your following list");
        }
    } else {
            throw new BadRequestException("The user_id not exist");
        }}


}
