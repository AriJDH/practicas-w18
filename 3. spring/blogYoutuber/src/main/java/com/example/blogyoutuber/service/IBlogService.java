package com.example.blogyoutuber.service;

import com.example.blogyoutuber.dto.request.BlogDTORequest;

public interface IBlogService {
    public Long createBlog(BlogDTORequest blogDTORequest);
}
