package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromoPostRepository implements IPromoPost{

    private Map<Integer, Post> promoPost = new HashMap<Integer, Post>();
    private Integer count = 0;

    @Override
    public PromoPostRepository getPromoPostById(int id) {
        return null;
    }

    @Override
    public Integer addPost(Post post) {
        promoPost.put(count, post);
        count++;
        return count-1;
    }

    @Override
    public List<PromoPostRepository> getPromoPostList() {
        //return new ArrayList<Post>(promoPost.values());
        return null;
    }

}
