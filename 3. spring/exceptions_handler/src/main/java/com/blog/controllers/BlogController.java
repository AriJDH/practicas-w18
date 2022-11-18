package com.blog.controllers;

import com.blog.services.BlogServiceIMP;
import com.blog.services.IBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class BlogController {
  private final IBlogService blogService;

  public BlogController(BlogServiceIMP blogService) {
    this.blogService = blogService;
  }

  @PostMapping("/blog")
  public void createBlog() {}

  @GetMapping("")
  public void getBlog() {}
}
