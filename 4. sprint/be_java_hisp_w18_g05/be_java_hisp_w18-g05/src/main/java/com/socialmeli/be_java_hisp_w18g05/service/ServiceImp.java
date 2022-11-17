package com.socialmeli.be_java_hisp_w18g05.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImp implements IService{

    private IRepository repository;


    public ServiceImp(IRepository repository) {
        this.repository = repository;
    }




    @Override
    public SellerFollowersListDTOResponse getFollowers(Integer seller_id) {
        Seller seller = repository.getByIdSeller(seller_id); // Get seller from repository
        List<Buyer> followers = seller.getFollowers(); // Get seller's followers list

        List<BuyerDTOResponse> followersDTO = new ArrayList<>();

        for (Buyer buyer : followers){ // Loop for every follower in followers list
            BuyerDTOResponse temp = new BuyerDTOResponse(buyer); // Create a buyerDTO from every follower
            followersDTO.add(temp); // Add buyerDTO to the final list
        }

        SellerFollowersListDTOResponse sellerFollowersListDTOResponse = new SellerFollowersListDTOResponse(seller.getUser_id(), seller.getName(), followersDTO);
        return sellerFollowersListDTOResponse;
    }
    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

        Seller s = repository.getByIdSeller(userIdToFollow);
        Buyer b = repository.getByIdBuyer(userId);
        if (s == null) {
            throw new NotFoundException("Seller id " + userId + " not found");
        }
        if (b == null) {
            throw new NotFoundException("Buyer id " + userIdToFollow + " not found");
        }
        b.addFollowed(s);
        s.addFollower(b);
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow){
        Seller s = repository.getByIdSeller(userIdToUnfollow);
        Buyer b = repository.getByIdBuyer(userId);
        if (s == null) {
            throw new NotFoundException("Seller id " + userId + " not found");
        }
        if (b == null) {
            throw new NotFoundException("Buyer id " + userIdToUnfollow + " not found");
        }
        b.unFollowed(s);
        s.unFollower(b);
    }

    /*
    @Override
    public SellerFollowersCountDTOResponse followersCount(Integer user_id){
        Integer countedFollowers;
        SellerFollowersCountDTOResponse sellerCount = new SellerFollowersCountDTOResponse();
        for(Seller seller: repository.getAllSellers()){
            if(user_id.equals(seller.getUser_id())){
                countedFollowers = seller.getFollowers().size();
                sellerCount = new SellerFollowersCountDTOResponse(seller.getUser_id(),seller.getName(),countedFollowers);
            }
        }
        return sellerCount;
    }*/

}
