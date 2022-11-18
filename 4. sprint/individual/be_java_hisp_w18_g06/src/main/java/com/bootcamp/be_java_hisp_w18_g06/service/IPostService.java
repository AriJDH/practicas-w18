package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PromoResDTO;

import java.util.List;

public interface IPostService {

    void savePost(PostDTO postDTO);
	void savePostPromo(PostPromoDTO postPromoDTO);
	// US006
	List<PostDTO> findAllPostsByUser(int id);
	List<PostDTO> sortedByAscAndDesc(int id, String order);
}
