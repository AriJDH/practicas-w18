package com.socialmeli2.be_java_hisp_w18g05.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli2.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli2.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli2.be_java_hisp_w18g05.dto.response.BuyerDTOResponse;

import com.socialmeli2.be_java_hisp_w18g05.dto.response.BuyerFollowedListDTOResponse;
import com.socialmeli2.be_java_hisp_w18g05.dto.response.SellerDTOResponse;

import com.socialmeli2.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import com.socialmeli2.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli2.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli2.be_java_hisp_w18g05.entity.Post;

import com.socialmeli2.be_java_hisp_w18g05.entity.Product;

import com.socialmeli2.be_java_hisp_w18g05.entity.Seller;
import com.socialmeli2.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli2.be_java_hisp_w18g05.exceptions.InvalidParameterException;
import com.socialmeli2.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli2.be_java_hisp_w18g05.repository.IRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public SellerFollowersListDTOResponse followersFilter(Integer seller_id, String order) { // Filter by order

        SellerFollowersListDTOResponse response = new SellerFollowersListDTOResponse();

        if (order != null){
            if (order.equals("name_asc")){
                response = getFollowersAZ(seller_id); // Call the AZ method
            } else if (order.equals("name_desc")) {
                response = getFollowersZA(seller_id); // Call the ZA method
            } else {
                throw new InvalidParameterException("The parameter " + order + " isn't valid"); // Exception if order isn't valid
            }
        }else {
            throw new InvalidParameterException("You need to specify asc or desc order"); // Throw Exception if order isn't valid
        }

        return response;
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
        // serchs buyer in seller's followers list
        Buyer seguidor = s.getFollowers().stream().filter(x->x.getUser_id().equals(userId)).findFirst().orElse(null);

        if (seguidor != null){
            throw new InvalidException("The buyer id " + userId +" is already following the seller id " + userIdToFollow);
        }

        repository.addFollowed(b, s);
        repository.addFollower(b, s);

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
        // serchs buyer in seller's followers list
        Buyer seguidor = s.getFollowers().stream().filter(x->x.getUser_id().equals(userId)).findFirst().orElse(null);

        if (seguidor == null){
            throw new InvalidException("The buyer id " + userId +" does not follow the seller id " + userIdToUnfollow);
        }

        repository.unfollow(b, s);
    }



    @Override
    public SellerPostListDTOResponse followedPostList(Integer user_id, String order) {

        if (order == null)
            order = "date_desc"; // date_desc by default if order is null
        return orderByDate(user_id, order);
    }

    public SellerPostListDTOResponse orderByDate(Integer userId, String order){
        Buyer b = repository.getByIdBuyer(userId);
        if (b == null) {
            throw new NotFoundException("Buyer id " + userId + " not found");
        }
        List<Seller> listSeller = b.getFolloweds();
        if (listSeller == null) {
            throw new NotFoundException("Buyer id " + userId + " doesn´t have followers");
        }
        // Get all posts from all sellers that the buyer follows:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String stringDateFormatter;

        List<PostDTOResponse> listPostDTO = new ArrayList<>();
        for (Seller s : listSeller) {
            for( Post p: s.getPosts()){
                stringDateFormatter = p.getDate().format(formatter);
                listPostDTO.add( new PostDTOResponse(s.getUser_id(), p.getPost_id(), stringDateFormatter, op.convertValue(p.getProduct(), ProductDTOResponse.class), p.getCategory(), p.getPrice()));
            }
        }
        // Order by date, depending on the order parameter

        if(order.equals("date_asc")){
            listPostDTO.sort(Comparator.comparing(PostDTOResponse::getDate)); // ordenamiento descenciente por fechas
        } else if (order.equals("date_desc")) {
            listPostDTO.sort(Comparator.comparing(PostDTOResponse::getDate).reversed());
        } else{
            throw new InvalidException("Invalid order");
        }
        // filter by date minus 2 weeks
        List<PostDTOResponse> listPostAux = new ArrayList<>();
        for (PostDTOResponse p : listPostDTO) {
            LocalDate localDateFormatter = LocalDate.parse(p.getDate(), formatter);
            if (localDateFormatter.isAfter(LocalDate.now().minusWeeks(2))) {
                listPostAux.add(p);
            }
        }
        return new SellerPostListDTOResponse(userId, listPostAux);
    }


    @Override
    public SellerFollowersListDTOResponse getFollowersAZ(Integer seller_id) {
        SellerFollowersListDTOResponse followersDTO = getFollowers(seller_id); // Call the default method

        Comparator<BuyerDTOResponse> comparator = Comparator.comparing(BuyerDTOResponse::getUser_name); // Build a comparator with username

        // Order AZ in new sortedList
        List<BuyerDTOResponse> sortedList = followersDTO
                .getFollowers()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        // Build DTO with new sortedList
        SellerFollowersListDTOResponse followersDTOAZ = new SellerFollowersListDTOResponse(followersDTO.getUser_id(), followersDTO.getUser_name(), sortedList);

        return followersDTOAZ;
    }

    @Override
    public SellerFollowersListDTOResponse getFollowersZA(Integer seller_id) {
        SellerFollowersListDTOResponse followersDTO = getFollowers(seller_id); // Call the default method

        Comparator<BuyerDTOResponse> comparator = Comparator.comparing(BuyerDTOResponse::getUser_name); // Build a comparator with username

        // Order ZA in new sortedList
        List<BuyerDTOResponse> sortedList = followersDTO
                .getFollowers()
                .stream()
                .sorted(comparator
                        .reversed())
                .collect(Collectors.toList());

        // Build DTO with new sortedList
        SellerFollowersListDTOResponse followersDTOAZ = new SellerFollowersListDTOResponse(followersDTO.getUser_id(), followersDTO.getUser_name(), sortedList);

        return followersDTOAZ;
    }

    @Override
    public BuyerFollowedListDTOResponse followedsFilter(Integer seller_id, String order) { // Filter by order
        BuyerFollowedListDTOResponse response = new BuyerFollowedListDTOResponse();

        if (order != null){
            if (order.equals("name_asc")){
                response = getFollowedsAZ(seller_id); // Call the AZ method
            } else if (order.equals("name_desc")) {
                response = getFollowedsZA(seller_id); // Call the ZA method
            }else {
                throw new InvalidParameterException("The parameter " + order + " isn't valid"); // Throw Exception if order isn't valid
            }
        }else {
            throw new InvalidParameterException("You need to specify asc or desc order"); // Throw Exception if order isn't valid
        }

        return response;
    }

    @Override
    public BuyerFollowedListDTOResponse getFolloweds(Integer buyer_id) {

        Buyer buyer = repository.getByIdBuyer(buyer_id); // Get buyer from repository
        if (buyer == null){
            throw new NotFoundException("Can't found user with id " + buyer_id); // Throw exception if buyer doesn't exist
        }
        List<Seller> followeds = buyer.getFolloweds(); // Get buyer's followed list
        List<SellerDTOResponse> followedsDTO = new ArrayList<>();

        for (Seller seller : followeds) { // Loop for every followed in followed list
            SellerDTOResponse temp = new SellerDTOResponse(seller); // Create a sellerDTO from every followed
            followedsDTO.add(temp); // Add sellerDTO to the final list

        }
        return new BuyerFollowedListDTOResponse(buyer.getUser_id(), buyer.getName(), followedsDTO);
    }

    @Override
    public BuyerFollowedListDTOResponse getFollowedsAZ(Integer buyer_id) {
        BuyerFollowedListDTOResponse followedsDTO = getFolloweds(buyer_id); // Call default method

        Comparator<SellerDTOResponse> comparator = Comparator.comparing(SellerDTOResponse::getUser_name); // Build a comparator with username

        // Order AZ in new sortedlist
        List<SellerDTOResponse> sortedList = followedsDTO
                .getFollowed()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        // Build DTO with sortedList
        BuyerFollowedListDTOResponse followedsDTOAZ = new BuyerFollowedListDTOResponse(followedsDTO.getUser_id(), followedsDTO.getUser_name(), sortedList);

        return followedsDTOAZ;
    }

    @Override
    public BuyerFollowedListDTOResponse getFollowedsZA(Integer buyer_id) {
        BuyerFollowedListDTOResponse followedsDTO = getFolloweds(buyer_id); // Call default method

        Comparator<SellerDTOResponse> comparator = Comparator.comparing(SellerDTOResponse::getUser_name); // Build a comparator with username

        // Order AZ in new sortedlist
        List<SellerDTOResponse> sortedList = followedsDTO
                .getFollowed()
                .stream()
                .sorted(comparator
                        .reversed())
                .collect(Collectors.toList());

        // Build DTO with sortedList
        BuyerFollowedListDTOResponse followedsDTOAZ = new BuyerFollowedListDTOResponse(followedsDTO.getUser_id(), followedsDTO.getUser_name(), sortedList);

        return followedsDTOAZ;
    }

    //For US0002
    @Override
    public SellerFollowersCountDTOResponse followersCount(Integer user_id){
        Seller seller = repository.getByIdSeller(user_id); // Get seller from repository
        if (seller == null) {
            throw new NotFoundException("Seller id " + user_id + " not found"); // Throw exception if seller doesn't exist
        }
        List<Buyer> followers = seller.getFollowers(); //Get followers from seller
        Integer countedFollowers = followers.size(); // Get size of the list of followers
        //Create DTO response
        SellerFollowersCountDTOResponse sellerCount = new SellerFollowersCountDTOResponse(seller.getUser_id(), seller.getName(),countedFollowers);
        return  sellerCount;
    }

    //For US 0005
    @Override
    public void newPost(@Valid NewPostDTORequest post){

        Integer user_id = post.getUser_id(); // Get post asociated with this id
        Seller seller = repository.getByIdSeller(user_id); // Get seller from repository

        if (seller == null) {  //Exception non existing seller
            throw new NotFoundException("Seller id " + user_id + " not found");
        }
        //Create DTO of the product
        Product product = new Product(post.getProduct().getProduct_id(),post.getProduct().getProduct_name(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes());

        //Convert the string to date time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(post.getDate(),formatter);

        //Create DTO of the post
        Post newPost = new Post(repository.addPost(), localDate,product ,post.getCategory(),post.getPrice());

        seller.getPosts().add(newPost);
    }

}

