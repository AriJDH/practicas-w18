package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.PostDTORes;
import com.example.SocialMeli2.dto.respose.PostFollowedByDateDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;
import com.example.SocialMeli2.entity.Post;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.BadRequestException;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IUserBuyerRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;
import com.example.SocialMeli2.util.Sorter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserBuyerServiceImp implements IUserBuyerService {
    private final IUserBuyerRepository userBuyerRepository;
    private final IUserSellerRepository userSellerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository, IUserSellerRepository userSellerRepository) {
        this.userBuyerRepository = userBuyerRepository;
        this.userSellerRepository = userSellerRepository;
    }

    private Boolean validateBuyer(Integer id) {
        Boolean valid = false;
        List<UserBuyer> buyers = userBuyerRepository.findAll();
        for (UserBuyer buyer : buyers) {
            if (buyer.getUser_id().equals(id)) {
                valid = true;
            }
        }
        return valid;
    }

    private Boolean validateSeller(Integer id) {
        Boolean valid = false;
        List<UserSeller> sellers = userSellerRepository.findAll();
        for (UserSeller seller : sellers) {
            if (seller.getUser_id().equals(id)) {
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        if (validateBuyer(userId) && validateSeller(userIdToFollow)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            UserSeller seller = userSellerRepository.findById(userIdToFollow);
            if (!(buyer.getFollowed().contains(seller)) && !(seller.getFollowers().contains(buyer))) {
                buyer.getFollowed().add(seller);
                seller.getFollowers().add(buyer);
            } else {
                throw new BadRequestException("The user " + userIdToFollow + " is already in your follow list");
            }
        } else {
            if (!validateBuyer(userId) && !validateSeller(userIdToFollow)){
                throw new UserNotFoundException("The buyer "+userId +" and the seller "+userIdToFollow+" not exist");
            } else if (!validateBuyer(userId) && validateSeller(userIdToFollow)){
                throw new UserNotFoundException("The buyer "+userId +" not exist");
            } else if (!validateSeller(userIdToFollow) && validateBuyer(userId)){
                throw new UserNotFoundException("The seller "+userIdToFollow +" not exist");
            }
        }
    }


    @Override
    public FollowedListDTORes getFollowed(Integer userId, String order) {
        if (validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> sellers = buyer.getFollowed();
            List<UserDTORes> userDTOResList = sellers.stream().map(e -> new UserDTORes(e)).collect(Collectors.toList());
            if (!order.equals("invalid"))
                Sorter.sortedByName(userDTOResList, order);
            else
                throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");
            return new FollowedListDTORes(buyer.getUser_id(), buyer.getUser_name(), userDTOResList);
        } else {
            throw new UserNotFoundException("The buyer "+userId +" not exist");
        }
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        if (validateBuyer(userId)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            List<UserSeller> followed = buyer.getFollowed();
            List<PostDTORes> postsFollowed = new ArrayList<>();
            getPostListSeller(followed, postsFollowed);

            List<PostDTORes> filterList = filterPostByDate(postsFollowed);

            if (!order.equals("invalid"))
                Sorter.sortByDate(filterList, order);
            else
                throw new BadRequestException("Enter 'date_asc' for ascending order or 'date_desc' for descending order.");
            return new PostFollowedByDateDTORes(buyer.getUser_id(), filterList);
        } else {
            throw new UserNotFoundException("The buyer "+userId +" not exist");
        }
    }

    private List<PostDTORes> filterPostByDate(List<PostDTORes> postDTOResList) {
        return postDTOResList.stream().
                filter(postDTORes -> postDTORes.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());
    }

    private void getPostListSeller(List<UserSeller> followed, List<PostDTORes> postsFollowed) {
        for (UserSeller seller : followed) {
            for (Post post : seller.getPosts()) {
                postsFollowed.add(new PostDTORes(seller.getUser_id(), post));
            }
        }
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        if (validateBuyer(userId) && validateSeller(userIdToUnfollow)) {
            UserBuyer buyer = userBuyerRepository.findById(userId);
            UserSeller seller = userSellerRepository.findById(userIdToUnfollow);
            if (buyer.getFollowed().contains(seller) && (seller.getFollowers().contains(buyer))) {
                buyer.getFollowed().remove(seller);
                seller.getFollowers().remove(buyer);
            } else {
                throw new BadRequestException("The user " + userIdToUnfollow + " is not in your following list");
            }
        } else {
            if (!validateBuyer(userId) && !validateSeller(userIdToUnfollow)){
                throw new UserNotFoundException("The buyer "+userId +" and the seller "+userIdToUnfollow+" not exist");
            } else if (!validateBuyer(userId) && validateSeller(userIdToUnfollow) ){
                throw new UserNotFoundException("The buyer "+userId +" not exist");
            } else if (!validateSeller(userIdToUnfollow) && validateBuyer(userId)){
                throw new UserNotFoundException("The seller "+userIdToUnfollow +" not exist");
            }
        }
    }
}
