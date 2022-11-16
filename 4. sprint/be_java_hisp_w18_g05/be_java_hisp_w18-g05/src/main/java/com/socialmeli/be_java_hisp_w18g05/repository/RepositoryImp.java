package com.socialmeli.be_java_hisp_w18g05.repository;


import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RepositoryImp implements IRepository{

    private List<Buyer> buyers;
    private List<Seller> sellers;

    public RepositoryImp() {
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
    public void addPost(Integer seller_id, Post post) {

    }

    @Override
    public Buyer getByIdBuyer(Integer buyer_id) {
        return null;
    }

    @Override
    public Seller getByIdSeller(Integer seller_id) {
        return null;
    }

    void fillDB(){

        buyers.add(new Buyer(1, "buyer1"));
        buyers.add(new Buyer(2, "buyer2"));
        buyers.add(new Buyer(3, "buyer3"));
        buyers.add(new Buyer(4, "buyer4"));
        buyers.add(new Buyer(5, "buyer5"));

        sellers.add(new Seller(1, "seller1"));
        sellers.add(new Seller(2, "seller2"));
        sellers.add(new Seller(3, "seller3"));
        sellers.add(new Seller(4, "seller4"));
        sellers.add(new Seller(5, "seller5"));

        sellers.add(new Seller(6, "seller6", Arrays.asList(buyers.get(0), buyers.get(1))));
        buyers.add(new Buyer(6, "buyer6", Arrays.asList(sellers.get(0), sellers.get(1))));
    }
}
