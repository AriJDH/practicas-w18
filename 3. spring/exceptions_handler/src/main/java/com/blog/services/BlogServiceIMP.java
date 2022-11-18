package com.blog.services;

import com.blog.repository.BlogRepositoryIMP;
import com.blog.repository.IBlogRepository;

public class BlogServiceIMP implements IBlogService {
  private final IBlogRepository blogRepository;

  public BlogServiceIMP(BlogRepositoryIMP blogRepository) {
    this.blogRepository = blogRepository;
  }

  @Override
  public Long createBlog() {
    // TODO Auto-generated method stub
    return null;
  }
}
