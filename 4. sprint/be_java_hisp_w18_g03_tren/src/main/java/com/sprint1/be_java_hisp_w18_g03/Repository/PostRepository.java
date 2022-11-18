package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> postList = new ArrayList<Post>();

    public Post findByIdPost(Integer postId) {
        return postList.stream().filter(p->p.getPostId().equals(postId)).findFirst().orElse(null);
    }

    public List<Post> findByUser(Integer userId) {
        return postList.stream().filter(p-> p.getUser().getUserId().equals(userId)).collect(Collectors.toList());
    }

    public boolean addPost(Post post) {
        postList.add(post);
        return true;
    }

    public Integer getPostsSizeList() {
        return postList.size();
    }

}
