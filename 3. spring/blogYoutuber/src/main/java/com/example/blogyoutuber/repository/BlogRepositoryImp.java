package com.example.blogyoutuber.repository;

import com.example.blogyoutuber.entity.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImp implements IBlogRepository{

    private Map<Long, BlogPost> blogPostMap;

    public BlogRepositoryImp() {
        this.blogPostMap = new HashMap<>();
    }

    @Override
    public Long createBlog(BlogPost blog) {
        blogPostMap.put(blog.getId(), blog);
        return id;
    }
}
