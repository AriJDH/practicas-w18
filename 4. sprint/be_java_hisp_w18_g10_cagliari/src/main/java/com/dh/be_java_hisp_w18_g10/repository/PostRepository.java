package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.exception.GenericException;
import com.dh.be_java_hisp_w18_g10.util.DateHandler;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{

    private final Map<Integer, Post> posts = new HashMap<Integer, Post>();
    private Integer count = 1;

    @Override
    public Post getPostById(int postId) {
        return posts.get(postId);
    }

    @Override
    public Integer addPost(Post post) {
        posts.put(count, post);
        count++;
        return count-1;
    }
    @Override
    public List<Post> getPosts() {
        return new ArrayList<Post>(posts.values());
    }
    @Override
    public List<Post> getUserPosts(int userId) {
        return getPosts()
                .stream()
                .filter(p -> p.getUserId() == userId)
                .collect(Collectors.toList());
    }
    @Override
    public List<Post> getUserPostsFilterByDays(int userId, int days) {
        return getUserPosts(userId)
                .stream()
                .filter(p -> DateHandler.isLocalDateAfter(p.getDate(), days))
                .collect(Collectors.toList());
    }
    @Override
    public List<Post> getUserPostsFilterByDays(int userId, int days, String order) {
        List<Post> posts = getUserPostsFilterByDays(userId, days);
        sortPostListBy(posts, order);
        return posts;
    }

    private void sortPostListBy(List<Post> postList, String order) {
        switch (order) {
            case "date_asc":
                postList.sort(Comparator.comparing(Post::getDate));
                break;
            case "date_desc":
                postList.sort(Comparator.comparing(Post::getDate).reversed());
                break;
            default:
                throw new GenericException("Parametro no valido");
        }
    }

}
