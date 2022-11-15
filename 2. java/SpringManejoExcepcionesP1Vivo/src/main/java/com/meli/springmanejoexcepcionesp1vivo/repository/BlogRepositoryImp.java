package com.meli.springmanejoexcepcionesp1vivo.repository;

import com.meli.springmanejoexcepcionesp1vivo.entity.Blog;
import com.meli.springmanejoexcepcionesp1vivo.exception.BlogExistException;
import com.meli.springmanejoexcepcionesp1vivo.exception.BlogNoExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BlogRepositoryImp implements IBlogRepository{

    private List<Blog> blogList = new ArrayList<>(){{
       add(new Blog(1,"blog uno","juan",new Date()));
    }};

    @Override
    public Blog selectBlog(Integer id) {
        var blog = blogList.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        return blog;
    }

    @Override
    public Blog createBlog(Blog blog) {
        if(blogList.stream().filter( b -> b.getId().equals(blog.getId())).findFirst().orElse(null) != null){
            return null;
        }
        blogList.add(blog);
        return blog;
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogList;
    }
}
