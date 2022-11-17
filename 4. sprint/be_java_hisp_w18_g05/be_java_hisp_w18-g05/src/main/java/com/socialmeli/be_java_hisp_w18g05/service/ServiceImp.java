package com.socialmeli.be_java_hisp_w18g05.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerFollowedListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements IService {

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

        for (Buyer buyer : followers) { // Loop for every follower in followers list
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

    @Override
    public BuyerFollowedListDTOResponse getFolloweds(Integer buyer_id) {

        Buyer buyer = repository.getByIdBuyer(buyer_id); // Get buyer from repository
        List<Seller> followeds = buyer.getFolloweds(); // Get buyer's followed list
        List<SellerDTOResponse> followedsDTO = new ArrayList<>();

        for (Seller seller : followeds) { // Loop for every followed in followed list
            SellerDTOResponse temp = new SellerDTOResponse(seller); // Create a sellerDTO from every followed
            followedsDTO.add(temp); // Add sellerDTO to the final list

        }
        return new BuyerFollowedListDTOResponse(buyer.getUser_id(), buyer.getName(), followedsDTO);
    }


    @Override
    public SellerFollowersCountDTOResponse followersCount(Integer user_id){
        Seller seller = repository.getByIdSeller(user_id); // Get seller from repository
        List<Buyer> followers = seller.getFollowers();
        Integer countedFollowers = followers.size();

        SellerFollowersCountDTOResponse sellerCount = new SellerFollowersCountDTOResponse(seller.getUser_id(),seller.getName(),countedFollowers);

        return  sellerCount;
    }


    @Override
    public void newPost(NewPostDTORequest post){
        Integer user_id = post.getUser_id();
        Seller seller = repository.getByIdSeller(user_id); // Get seller from repository
        //List<Post> postList = seller.getPosts();
        Product product = new Product(post.getProduct().getProduct_id(),post.getProduct().getProduct_name(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate = LocalDate.parse(post.getDate(),formatter);
        Post newPost = new Post(post.getUser_id(), localDate,product ,post.getCategory(),post.getPrice());

        //postList.add(newPost);
        seller.getPosts().add(newPost);
    }
        @Override
        public void follow (Integer userId, Integer userIdToFollow){

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
        public void unfollow (Integer userId, Integer userIdToUnfollow){
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
        


}

