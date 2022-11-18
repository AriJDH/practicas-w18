package com.example.blogyoutuber.repository;

import com.example.blogyoutuber.entity.BlogPost;

public interface IBlogRepository {
    public Long createBlog(BlogPost blog);
}
