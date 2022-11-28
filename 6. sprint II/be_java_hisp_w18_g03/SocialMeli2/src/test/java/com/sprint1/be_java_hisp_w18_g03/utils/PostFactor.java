package com.sprint1.be_java_hisp_w18_g03.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.User;

import java.time.LocalDate;

public class PostFactor {

    public static Post getPost(Integer id, User user){
        return new Post(id, user,LocalDate.of(2022, 8,3), null);
    }
}
