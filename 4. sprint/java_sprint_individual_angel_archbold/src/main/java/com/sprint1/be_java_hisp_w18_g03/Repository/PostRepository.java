package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements IPostRepository {
  private List<Post> postList = new ArrayList<Post>();

  public Post findByIdPost(Integer postId) {
    return postList
      .stream()
      .filter(p -> p.getPostId().equals(postId))
      .findFirst()
      .orElse(null);
  }

  public List<Post> findByUser(Integer userId) {
    return postList
      .stream()
      .filter(p -> p.getUser().getUserId().equals(userId))
      .collect(Collectors.toList());
  }

  public boolean addPost(Post post) {
    postList.add(post);
    return true;
  }

  public Integer getPostsSizeList() {
    return postList.size();
  }

  public Integer getPostsWithDiscountSizeList(Integer userId) {
    Integer count = 0;

    for (Post post : postList) {
      if (post.getUser().getUserId() == userId) {
        if (
          post.getProducto().getHasPromo() != null &&
          post.getProducto().getHasPromo() == true
        ) {
          count++;
        }
      }
    }

    return count;
  }

  public List<Product> getProductsWithDiscount(Integer userId) {
    ArrayList<Product> userPosts = new ArrayList<>();

    for (Post post : postList) {
      if (post.getUser().getUserId() == userId) {
        if (
          post.getProducto().getHasPromo() != null &&
          post.getProducto().getHasPromo() == true
        ) {
          userPosts.add(post.getProducto());
        }
      }
    }

    return userPosts;
  }
}
