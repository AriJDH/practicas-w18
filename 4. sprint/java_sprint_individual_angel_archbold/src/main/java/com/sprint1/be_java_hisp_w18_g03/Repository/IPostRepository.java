package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;

import java.util.List;

public interface IPostRepository {
  Post findByIdPost(Integer postId);
  List<Post> findByUser(Integer userId);
  boolean addPost(Post post);

  Integer getPostsSizeList();

  Integer getPostsWithDiscountSizeList(Integer userId);
  List<Product> getProductsWithDiscount(Integer userId);
}
