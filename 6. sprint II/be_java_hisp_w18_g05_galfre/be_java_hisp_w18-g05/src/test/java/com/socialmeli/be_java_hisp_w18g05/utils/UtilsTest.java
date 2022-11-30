package com.socialmeli.be_java_hisp_w18g05.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w18g05.dto.response.PostDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.ProductDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerPostListDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsTest {

    public static Buyer getBuyer1(){
        return new Buyer(1,"Buyer1");
    }

    public static Buyer getBuyer2(){
        return new Buyer(2,"Buyer2");
    }
    public static Seller getSeller10(){
        return new Seller(10,"Seller10");
    }

    public static Product getProduct1(){
        return new Product(1,"silla1","gamer1","racer1","red1","special1");
    }
    public static Product getProduct2(){
        return new Product(2,"silla2","gamer2","racer2","red2","special2");
    }
    public static Product getProduct3(){
        return new Product(3,"silla3","gamer3","racer3","red3","special3");
    }
    public static Post getPost1(){
        return new Post(1, LocalDate.now().minusDays(6),getProduct1(),200,2500.50);
    }

    public static Post getPost2(){
        return new Post(2,LocalDate.now().minusDays(8),getProduct2(),200,2500.50);
    }
    public static Post getPost3(){
        return new Post(3,LocalDate.now().minusDays(10),getProduct3(),200,2500.50);
    }

    public static Post getPost4(){
        return new Post(4,LocalDate.now().minusDays(11),getProduct3(),200,2500.50);
    }

    public static Post getPost5(){
        return new Post(5,LocalDate.now().minusDays(13),getProduct3(),200,2500.50);
    }

    public static ProductDTOResponse getProductDTO1(){
        return new ProductDTOResponse(1,"silla1","gamer1","racer1","red1","special1");
    }
    public static ProductDTOResponse getProductDTO2(){
        return new ProductDTOResponse(2,"silla2","gamer2","racer2","red2","special2");
    }
    public static ProductDTOResponse getProductDTO3(){
        return new ProductDTOResponse(3,"silla3","gamer3","racer3","red3","special3");
    }
    public static PostDTOResponse getPostDTO1(Integer userId){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String datetext = LocalDate.now().minusDays(6).format(formatters);
        return new PostDTOResponse(userId, 1,datetext, getProductDTO1(),200,2500.50);
    }

    public static PostDTOResponse getPostDTO2(Integer userId){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String datetext = LocalDate.now().minusDays(8).format(formatters);
        return new PostDTOResponse(userId, 2,datetext, getProductDTO2(),200,2500.50);
    }

    public static PostDTOResponse getPostDTO3(Integer userId){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String datetext = LocalDate.now().minusDays(10).format(formatters);
        return new PostDTOResponse(userId, 3,datetext, getProductDTO3(),200,2500.50);
    }

    public static SellerFollowersCountDTOResponse getSellerDTOWith2Buyers(Integer userId){
        return new SellerFollowersCountDTOResponse(userId, "Seller10", 2);
    }

    public static Seller getSellerWith2Buyer(Integer userId){
        return new Seller(userId, "Seller10", Arrays.asList(getBuyer1(), getBuyer2()));
    }

    public static SellerPostListDTOResponse getSellerPostListDTOResponseDesc(Integer userId){
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(10, getPost1().getPost_id(), getPost1().getDate().toString(), op.convertValue(getPost1().getProduct(), ProductDTOResponse.class), getPost1().getCategory(), getPost1().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, getPost2().getPost_id(), getPost2().getDate().toString(), op.convertValue(getPost2().getProduct(), ProductDTOResponse.class), getPost2().getCategory(), getPost2().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, getPost3().getPost_id(), getPost3().getDate().toString(), op.convertValue(getPost3().getProduct(), ProductDTOResponse.class), getPost3().getCategory(), getPost3().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, getPost4().getPost_id(), getPost4().getDate().toString(), op.convertValue(getPost4().getProduct(), ProductDTOResponse.class), getPost4().getCategory(), getPost4().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, getPost5().getPost_id(), getPost5().getDate().toString(), op.convertValue(getPost5().getProduct(), ProductDTOResponse.class), getPost5().getCategory(), getPost5().getPrice()));
        return new SellerPostListDTOResponse(userId, postDTOResponseList);
    }

    public static SellerPostListDTOResponse getSellerPostListDTOResponseAsc(Integer userId){
        ObjectMapper op = new ObjectMapper();
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<PostDTOResponse> postDTOResponseList = new ArrayList<>();
        postDTOResponseList.add(new PostDTOResponse(20, getPost5().getPost_id(), getPost5().getDate().toString(), op.convertValue(getPost5().getProduct(), ProductDTOResponse.class), getPost5().getCategory(), getPost5().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(20, getPost4().getPost_id(), getPost4().getDate().toString(), op.convertValue(getPost4().getProduct(), ProductDTOResponse.class), getPost4().getCategory(), getPost4().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, getPost3().getPost_id(), getPost3().getDate().toString(), op.convertValue(getPost3().getProduct(), ProductDTOResponse.class), getPost3().getCategory(), getPost3().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, getPost2().getPost_id(), getPost2().getDate().toString(), op.convertValue(getPost2().getProduct(), ProductDTOResponse.class), getPost2().getCategory(), getPost2().getPrice()));
        postDTOResponseList.add(new PostDTOResponse(10, getPost1().getPost_id(), getPost1().getDate().toString(), op.convertValue(getPost1().getProduct(), ProductDTOResponse.class), getPost1().getCategory(), getPost1().getPrice()));
        return new SellerPostListDTOResponse(userId, postDTOResponseList);
    }

    public static SellerPostListDTOResponse getSellerPostListDTOResponse(Integer userId){
        return new SellerPostListDTOResponse(userId, Arrays.asList(getPostDTO1(10),getPostDTO2(10),getPostDTO3(20)));
    }

    public static Buyer getBuyerWith2SellerWith5Post(Integer userId){
        List<Seller> sellerList = new ArrayList<>();
        List<Post> postList1 = new ArrayList<>();
        postList1.add(getPost1());
        postList1.add(getPost2());
        postList1.add(getPost3());
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        postList2.add(getPost4());
        postList2.add(getPost5());
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        return new Buyer(userId, "Buyer1", sellerList);
    }

    public static Buyer getBuyerWith2SellerWith3Post(Integer userId){
        List<Seller> sellerList = new ArrayList<>();
        List<Post> postList1 = new ArrayList<>();
        postList1.add(getPost1());
        postList1.add(getPost2());
        // lista de post del seller 20
        List<Post> postList2 = new ArrayList<>();
        postList2.add(getPost3());
        // Creación de los sellers
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        // asignamos post a los sellers
        sellerList.get(0).setPosts(postList1);
        sellerList.get(1).setPosts(postList2);
        return new Buyer(userId, "Buyer1", sellerList);
    }
    public static Buyer getBuyerWith2Sellers(Integer userId) {
        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        return new Buyer(userId, "Buyer1",sellerList );
    }
    public static Buyer getBuyerWithListOrderAsc (Integer userId){
        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(new Seller(10, "Seller10"));
        sellerList.add(new Seller(20, "Seller20"));
        sellerList.add(new Seller(30, "Seller30"));
        Buyer buyerReturn = new Buyer(userId, "Buyer1", sellerList);
        return buyerReturn;
    }

    public static Buyer getBuyerWithListOrderDesc (Integer userId){
        List<Seller> sellerList = new ArrayList<>();
        sellerList.add(new Seller(30, "Seller30"));
        sellerList.add(new Seller(20, "Seller20"));
        sellerList.add(new Seller(10, "Seller10"));
        Buyer buyerReturn = new Buyer(userId, "Buyer1", sellerList);
        return buyerReturn;
    }

    public static Seller getSellerWithListOrderDesc (Integer userId){
        List<Buyer> buyerList = new ArrayList<>();
        buyerList.add(new Buyer(3, "Buyer3"));
        buyerList.add(new Buyer(2, "Buyer2"));
        buyerList.add(new Buyer(1, "Buyer1"));
        Seller sellerReturn = new Seller(userId, "Seller1", buyerList);
        return sellerReturn;
    }

    public static Seller getSellerWithListOrderAsc (Integer userId){
        List<Buyer> buyerList = new ArrayList<>();
        buyerList.add(new Buyer(1, "Buyer1"));
        buyerList.add(new Buyer(2, "Buyer2"));
        buyerList.add(new Buyer(3, "Buyer3"));
        Seller sellerReturn = new Seller(userId, "Seller1", buyerList);
        return sellerReturn;
    }

}

