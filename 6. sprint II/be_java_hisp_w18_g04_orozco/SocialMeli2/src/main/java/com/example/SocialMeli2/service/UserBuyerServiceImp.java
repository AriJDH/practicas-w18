package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.*;
import com.example.SocialMeli2.entity.Post;
import com.example.SocialMeli2.entity.User;
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
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserBuyerServiceImp implements IUserBuyerService {
    private final IUserBuyerRepository userBuyerRepository;
    private final IUserSellerRepository userSellerRepository;

    public UserBuyerServiceImp(IUserBuyerRepository userBuyerRepository, IUserSellerRepository userSellerRepository) {
        this.userBuyerRepository = userBuyerRepository;
        this.userSellerRepository = userSellerRepository;
    }

    @Override
    public FollowDTORes follow(Integer userId, Integer userIdToFollow) {
        UserBuyer buyer = getBuyer(userId);
        UserSeller seller = getSeller(userIdToFollow);

        if (!(buyer.getFollowed().contains(seller)) && !(seller.getFollowers().contains(buyer))) {
            buyer.getFollowed().add(seller);
            seller.getFollowers().add(buyer);
        } else {
            throw new BadRequestException("The user " + userIdToFollow + " is already in your following list");
        }

        return new FollowDTORes(buyer.getUser_name(), seller.getUser_name());
    }

    @Override
    public FollowedListDTORes getFollowed(Integer userId, String order) {
        UserBuyer buyer = getBuyer(userId);
        List<UserSeller> sellers = buyer.getFollowed();
        List<UserDTORes> userDTOResList = sellers.stream().map(e -> new UserDTORes(e)).collect(Collectors.toList());
        if (!order.equals("invalid"))
            Sorter.sortedByName(userDTOResList, order);
        else
            throw new BadRequestException("Enter 'name_asc' for ascending alphabetical ordering or 'name_desc' for descending ordering.");

        return new FollowedListDTORes(buyer.getUser_id(), buyer.getUser_name(), userDTOResList);
    }

    @Override
    public PostFollowedByDateDTORes getLastPosts(Integer userId, String order) {
        UserBuyer buyer = getBuyer(userId);
        List<UserSeller> followed = buyer.getFollowed();
        List<PostDTORes> postsFollowed = new ArrayList<>();
        getPostListSeller(followed, postsFollowed);
        List<PostDTORes> filterList = filterPostByDate(postsFollowed);
        if (!order.equals("invalid"))
            Sorter.sortByDate(filterList, order);
        else
            throw new BadRequestException("Enter 'date_asc' for ascending order or 'date_desc' for descending order.");

        return new PostFollowedByDateDTORes(buyer.getUser_id(), filterList);
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
    public UnfollowDTORes unfollow(Integer userId, Integer userIdToUnfollow) {
        UserBuyer buyer = getBuyer(userId);
        UserSeller seller = getSeller(userIdToUnfollow);
        if (buyer.getFollowed().contains(seller) && (seller.getFollowers().contains(buyer))) {
            buyer.getFollowed().remove(seller);
            seller.getFollowers().remove(buyer);
        } else {
            throw new BadRequestException("The user " + userIdToUnfollow + " is not in your following list");
        }
        return new UnfollowDTORes(buyer.getUser_name(), seller.getUser_name());
    }

    private UserBuyer getBuyer(Integer id) {
        Optional<UserBuyer> optionalUserBuyer = userBuyerRepository.findById(id);
        UserBuyer buyer = optionalUserBuyer.orElseThrow(() -> new UserNotFoundException("The buyer " + id + " doesn't exist"));
        return buyer;
    }

    private UserSeller getSeller(Integer id) {
        Optional<UserSeller> optionalUserSeller = userSellerRepository.findById(id);
        UserSeller seller = optionalUserSeller.orElseThrow(() -> new UserNotFoundException("The seller " + id + " doesn't exist"));
        return seller;
    }
}
