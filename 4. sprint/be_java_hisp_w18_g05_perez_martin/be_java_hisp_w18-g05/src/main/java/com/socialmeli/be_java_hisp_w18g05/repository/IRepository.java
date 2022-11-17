package com.socialmeli.be_java_hisp_w18g05.repository;

import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import java.util.List;

public interface IRepository {

    List<Buyer> getAllBuyers();
    List<Seller> getAllSellers();
    int addPost();
    Buyer getByIdBuyer(Integer buyer_id);
    Seller getByIdSeller(Integer seller_id);

    /*
    void addFollow(Integer buyer_id, Integer seller_id);
    void unfollow(Integer buyer_id, Integer seller_id);
    Integer followersCount(Integer seller_id);

     */

}
