package com.socialmeli.be_java_hisp_w18g05.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPromoPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.request.CrudUserDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.BuyerFollowedListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.*;

import com.socialmeli.be_java_hisp_w18g05.exceptions.AlreadyExistsException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.InvalidParameterException;
import com.socialmeli.be_java_hisp_w18g05.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w18g05.repository.IRepository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
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
            response = getFollowers(seller_id); // Call the default method
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
        // serchs buyer in seller's followers list
        Buyer seguidor = s.getFollowers().stream().filter(x->x.getUser_id().equals(userId)).findFirst().orElse(null);

        if (seguidor == null){
            throw new InvalidException("The buyer id " + userId +" doesn´t follow the seller id " + userIdToUnfollow);
        }
        b.unFollowed(s);
        s.unFollower(b);
    }



    @Override
    public SellerPostListDTOResponse followedPostList(Integer user_id, String order) {

        if (order == null)
            order = "date_desc"; // date_desc by default if order is null
        return orderByDate(user_id, order);
    }




    private SellerPostListDTOResponse orderByDate(Integer userId, String order){
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
            response = getFolloweds(seller_id); // Call the default method
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
        SellerFollowersCountDTOResponse sellerCount = new SellerFollowersCountDTOResponse(seller.getUser_id(),seller.getName(),countedFollowers);
        return  sellerCount;
    }

    //For US 0005
    @Override
    public void newPost(NewPostDTORequest post){
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

    @Override
    public void addNewPromoPost(NewPromoPostDTORequest post) { // US0010
        Seller seller = repository.getByIdSeller(post.getUser_id()); // Get seller from repo

        if (seller == null){
            throw new NotFoundException("Seller id " + post.getUser_id() + " not found"); // Throw exception if seller not found
        }

        Product product = new Product(post.getProduct().getProduct_id(), // Extract product from bodyrequest
                post.getProduct().getProduct_name(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(post.getDate(), formatter); // LocalDate to String

        PromoPost newPromoPost = new PromoPost(repository.addPost(), localDate, product, post.getCategory(), post.getPrice(), post.getHas_promo(), post.getDiscount()); // Create new PromoPost

        seller.getPromoPosts().add(newPromoPost);
    }

    @Override
    public PromoProductsCountDTOResponse countPromoProducts(Integer user_id) { // US0011
        Seller seller = repository.getByIdSeller(user_id);
        if (seller == null) {
            throw new NotFoundException("Seller id " + user_id + " not found");
        }

        List<PromoPost> promoList = seller.getPromoPosts();
        Integer promoPosts = promoList.size();

        PromoProductsCountDTOResponse dtoResponse = new PromoProductsCountDTOResponse(user_id, seller.getName(), promoPosts);
        return dtoResponse;
    }

    @Override
    public PromoPostListDTOResponse allPromoPosts(Integer user_id) { // US0012
        Seller seller = repository.getByIdSeller(user_id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        if (seller == null){
            throw new NotFoundException("Seller id" + user_id + " not found");
        }

        List<PromoPostDTOResponse> promoPostDTO = new ArrayList<>();

        for (PromoPost post : seller.getPromoPosts()){
            ProductDTOResponse productDTO = new ProductDTOResponse(post.getProduct().getProduct_id(),
                    post.getProduct().getProduct_name(),
                    post.getProduct().getType(),
                    post.getProduct().getBrand(),
                    post.getProduct().getColor(),
                    post.getProduct().getNotes());

            String date = post.getDate().format(formatter);
            PromoPostDTOResponse postDTO = new PromoPostDTOResponse(user_id, post.getPost_id(), date, productDTO, post.getCategory(), post.getPrice(), post.getHas_promo(), post.getDiscount());
            promoPostDTO.add(postDTO);
        }

        PromoPostListDTOResponse promoPostListDTOResponse = new PromoPostListDTOResponse(user_id, seller.getName(), promoPostDTO);

        return promoPostListDTOResponse;
    }

    @Override
    public void addNewUser(CrudUserDTORequest user) {
        if (user.getUser_type().equals("seller")){
            addSeller(user);
        } else if (user.getUser_type().equals("buyer")) {
            addBuyer(user);
        } else {
            throw new InvalidParameterException("Parameter " + user.getUser_type() + " isn't valid");
        }
    }

    public void addSeller(CrudUserDTORequest seller){
        Seller sellertest = repository.getByIdSeller(seller.getUser_id());

        if (sellertest != null){
            throw new AlreadyExistsException("User id " + sellertest.getUser_id() + " already exists");
        }
        Seller sellerFinal = new Seller(seller.getUser_id(), seller.getUser_name());
        repository.addSeller(sellerFinal);
    }

    public void addBuyer(CrudUserDTORequest buyer){
        Buyer buyertest = repository.getByIdBuyer(buyer.getUser_id());

        if (buyertest != null){
            throw new AlreadyExistsException("User id " + buyer.getUser_id() + " already exists");
        }

        Buyer buyerFinal = new Buyer(buyer.getUser_id(), buyer.getUser_name());
        repository.addBuyer(buyerFinal);
    }

    @Override
    public void deleteBuyer(Integer user_id) {
        Buyer buyer = repository.getByIdBuyer(user_id);
        if (buyer == null){
            throw new NotFoundException("Buyer id" + user_id + " not found");
        }
        repository.deleteBuyer(buyer);
    }

    @Override
    public void deleteSeller(Integer user_id) {
        Seller seller = repository.getByIdSeller(user_id);
        if (seller == null){
            throw new NotFoundException("Seller id" + user_id + " not found");
        }
        repository.deleteSeller(seller);
    }

    @Override
    public void updateUser(CrudUserDTORequest user) {
        if(user.getUser_type().equals("seller")){
            updateSeller(user);
        } else if (user.getUser_type().equals("buyer")) {
            updateBuyer(user);
        }else {
            throw new InvalidParameterException("Parameter " + user.getUser_type() + " not valid");
        }
    }

    @Override
    public void updateBuyer(CrudUserDTORequest user) {
        Buyer buyer = repository.getByIdBuyer(user.getUser_id());
        if (buyer == null){
            throw new NotFoundException("Buyer id " + user.getUser_id() + " not found");
        }
        buyer.setName(user.getUser_name());
    }

    @Override
    public void updateSeller(CrudUserDTORequest user) {
        Seller seller = repository.getByIdSeller(user.getUser_id());
        if (seller == null){
            throw new NotFoundException("Buyer id " + user.getUser_id() + " not found");
        }
        seller.setName(user.getUser_name());
    }

    @Override
    public BuyerDTOResponse infoBuyer(Integer user_id) {
        Buyer buyer = repository.getByIdBuyer(user_id);

        if (buyer == null){
            throw new NotFoundException("Buyer id " + user_id + " not found");
        }

        BuyerDTOResponse response = new BuyerDTOResponse(buyer);

        return response;
    }

    @Override
    public InfoSellerDTOResponse infoSeller(Integer user_id) {
        Seller seller = repository.getByIdSeller(user_id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");

        if (seller == null){
            throw new NotFoundException("Buyer id " + user_id + " not found");
        }

        List<PostDTOResponse> postsDTO = new ArrayList<>();
        for (Post post : seller.getPosts()){
            ProductDTOResponse productDTO = new ProductDTOResponse(post.getProduct().getProduct_id(),
                    post.getProduct().getProduct_name(),
                    post.getProduct().getType(),
                    post.getProduct().getBrand(),
                    post.getProduct().getColor(),
                    post.getProduct().getNotes());

            String date = post.getDate().format(formatter);

            PostDTOResponse postDTO = new PostDTOResponse(seller.getUser_id(),
                    post.getPost_id(),
                    date,
                    productDTO,
                    post.getCategory(),
                    post.getPrice());

            postsDTO.add(postDTO);
        }
        List<PromoPostDTOResponse> promoPostsDTO = new ArrayList<>();
        for (PromoPost post : seller.getPromoPosts()){
            ProductDTOResponse productDTO = new ProductDTOResponse(post.getProduct().getProduct_id(),
                    post.getProduct().getProduct_name(),
                    post.getProduct().getType(),
                    post.getProduct().getBrand(),
                    post.getProduct().getColor(),
                    post.getProduct().getNotes());

            String date = post.getDate().format(formatter);

            PromoPostDTOResponse promoPostDTO = new PromoPostDTOResponse(seller.getUser_id(),
                    post.getPost_id(),
                    date,
                    productDTO,
                    post.getCategory(),
                    post.getPrice(),
                    post.getHas_promo(),
                    post.getDiscount());

            promoPostsDTO.add(promoPostDTO);
        }

        InfoSellerDTOResponse response = new InfoSellerDTOResponse(seller.getUser_id(), seller.getName(), postsDTO, promoPostsDTO);

        return response;
    }

    @Override
    public AllBuyersDTOResponse allBuyers() {
        List<Buyer> buyers = repository.getAllBuyers();
        List<BuyerDTOResponse> buyersDTO = new ArrayList<>();
        if (buyers == null){
            throw new NotFoundException("No hay users");
        }

        for (Buyer buyer : buyers){
            BuyerDTOResponse dto = new BuyerDTOResponse(buyer.getUser_id(), buyer.getName());
            buyersDTO.add(dto);
        }

        AllBuyersDTOResponse response = new AllBuyersDTOResponse(buyersDTO);
        return response;
    }

    @Override
    public AllSellersDTOResponse allSellers() {
        List<Seller> sellers = repository.getAllSellers();
        List<InfoSellerDTOResponse> responseList = new ArrayList<>();
        if (sellers == null){
            throw new NotFoundException("No hay sellers");
        }

        for (Seller seller : sellers){
            responseList.add(infoSeller(seller.getUser_id()));
        }

        AllSellersDTOResponse response = new AllSellersDTOResponse(responseList);
        return response;
    }

}

