package com.socialmeli.be_java_hisp_w18g05.utils;

import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;

import java.util.ArrayList;
import java.util.List;

public class test {
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
