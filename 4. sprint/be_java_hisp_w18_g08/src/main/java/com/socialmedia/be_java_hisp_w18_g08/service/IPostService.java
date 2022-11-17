package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.PostDTOReq;
import org.springframework.http.ResponseEntity;

public interface IPostService {

    void create(PostDTOReq postDTOReq);
}
