package com.socialmeli.be_java_hisp_w18g05.repository;


import com.socialmeli.be_java_hisp_w18g05.entity.Buyer;
import com.socialmeli.be_java_hisp_w18g05.entity.Post;
import com.socialmeli.be_java_hisp_w18g05.entity.Product;
import com.socialmeli.be_java_hisp_w18g05.entity.Seller;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RepositoryImp implements IRepository{

    private final List<Buyer> buyers = new ArrayList<>();
    private final List<Seller> sellers = new ArrayList<>();

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
        return buyers.stream().filter(b->b.getUser_id().equals(buyer_id)).findFirst().orElse(null);
    }

    @Override
    public Seller getByIdSeller(Integer seller_id) {
        return sellers.stream().filter(s->s.getUser_id().equals(seller_id)).findFirst().orElse(null);
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

        sellers.get(1).addPost(new Post(1, LocalDate.parse("2021-01-21"), new Product(62, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB","Sin Batería"), 100, 2800.69));
        sellers.get(0).addPost(new Post(2, LocalDate.parse("2022-11-17"), new Product(62, "Silla Gamer", "Gamer", "Razer", "Green with RGB","Special Edition"), 100, 2800.69));
        sellers.get(1).addPost(new Post(3, LocalDate.parse("2022-11-16"), new Product(62, "Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB","Sin Batería"), 100, 2800.69));

    }
}
