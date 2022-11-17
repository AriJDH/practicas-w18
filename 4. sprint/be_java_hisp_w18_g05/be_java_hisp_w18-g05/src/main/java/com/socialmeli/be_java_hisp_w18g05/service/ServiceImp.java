package com.socialmeli.be_java_hisp_w18g05.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements IService{

    private IRepository repository;
    private ObjectMapper op = new ObjectMapper();


    public ServiceImp(IRepository repository) {
        this.repository = repository;
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public SellerFollowersListDTOResponse getFollowers(Integer seller_id) {
        Seller seller = repository.getByIdSeller(seller_id); // Get seller from repository

        if(seller == null){
            throw new NotFoundException("Seller id " + seller_id + " not found");
        }

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
            throw new NotFoundException("Seller id " + userIdToFollow + " not found");
        }
        if (b == null) {
            throw new NotFoundException("Buyer id " + userId + " not found");
        }

        Buyer seguidor = s.getFollowers().stream().filter(x->x.getUser_id().equals(userId)).findFirst().orElse(null);

        if (seguidor != null){
            throw new InvalidException("The buyer id " + userId +" is already following the seller id " + userIdToFollow);
        }

        b.addFollowed(s);
        s.addFollower(b);
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow){
        Seller s = repository.getByIdSeller(userIdToUnfollow);
        Buyer b = repository.getByIdBuyer(userId);

        if (s == null) {
            throw new NotFoundException("Seller id " + userIdToUnfollow+ " not found");
        }
        if (b == null) {
            throw new NotFoundException("Buyer id " + userId  + " not found");
        }

        Buyer seguidor = s.getFollowers().stream().filter(x->x.getUser_id().equals(userId)).findFirst().orElse(null);

        if (seguidor == null){
            throw new InvalidException("The buyer id " + userId +" doesn´t follow the seller id " + userIdToUnfollow);
        }
        b.unFollowed(s);
        s.unFollower(b);
    }

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
    }

    @Override
    public SellerPostListDTOResponse followedPostList(Integer user_id) {

        Buyer b = repository.getByIdBuyer(user_id);
        if (b == null) {
            throw new NotFoundException("Buyer id " + user_id + " not found");
        }
        List<Seller> listSeller = b.getFolloweds();
        if (listSeller == null) {
            throw new NotFoundException("Buyer id " + user_id + " doesn´t have followers");
        }

        List<PostDTOResponse> listPostDTO = new ArrayList<>();
        for (Seller s : listSeller) {
            for( Post p: s.getPosts()){
                listPostDTO.add( new PostDTOResponse(s.getUser_id(), p.getPost_id(), p.getDate(), op.convertValue(p.getProduct(), ProductDTOResponse.class), p.getCategory(), p.getPrice()));
            }
        }

        listPostDTO.sort(Comparator.comparing(PostDTOResponse::getDate).reversed()); // ordenamiento descenciente por fechas

        // filter by date minus 2 weeks
        List<PostDTOResponse> listPostAux = new ArrayList<>();
        for (PostDTOResponse p : listPostDTO) {
            if (p.getDate().isAfter(LocalDate.now().minusWeeks(2))) {
                listPostAux.add(p);
            }
        }

        return new SellerPostListDTOResponse(user_id, listPostAux);
    }


}
