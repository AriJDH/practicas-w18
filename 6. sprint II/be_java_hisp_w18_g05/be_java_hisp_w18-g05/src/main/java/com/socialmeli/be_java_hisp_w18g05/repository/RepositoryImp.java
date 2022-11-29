package com.socialmeli.be_java_hisp_w18g05.repository;


import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryImp implements IRepository{

    private final List<Buyer> buyers = new ArrayList<>();
    private final List<Seller> sellers = new ArrayList<>();

    private Integer idPost;

    public RepositoryImp() {
        idPost = 1;
        fillDB();
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return null;
    }

    @Override
    public List<Seller> getAllSellers() {
        return null;
    }

    @Override
    public int addPost() {
        return idPost ++;
    }

    @Override
    public Buyer getByIdBuyer(Integer buyer_id) {
        return buyers.stream().filter(b->b.getUser_id().equals(buyer_id)).findFirst().orElse(null);
    }

    @Override
    public Seller getByIdSeller(Integer seller_id) {
        return sellers.stream().filter(s->s.getUser_id().equals(seller_id)).findFirst().orElse(null);
    }

    @Override
    public void addFollower(Buyer buyer, Seller seller) {
        seller.addFollower(buyer);
    }

    @Override
    public void addFollowed(Buyer buyer, Seller seller) {
        buyer.addFollowed(seller);
    }

    @Override
    public void unfollow(Buyer buyer, Seller seller) {
        buyer.unFollowed(seller);
        seller.unFollower(buyer);
    }


    void fillDB(){

        buyers.add(new Buyer(1, "buyer1"));
        buyers.add(new Buyer(2, "buyer2"));
        buyers.add(new Buyer(3, "buyer3"));
        buyers.add(new Buyer(4, "buyer4"));
        buyers.add(new Buyer(5, "buyer5"));

        sellers.add(new Seller(10, "seller1"));
        sellers.add(new Seller(20, "seller2"));
        sellers.add(new Seller(30, "seller3"));
        sellers.add(new Seller(40, "seller4"));
        sellers.add(new Seller(50, "seller5"));

    }
}
