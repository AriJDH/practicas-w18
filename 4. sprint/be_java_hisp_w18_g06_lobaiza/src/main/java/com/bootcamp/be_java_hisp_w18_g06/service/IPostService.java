package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDTO;

import java.util.List;

public interface IPostService {

    void savePost(PostDTO postDTO);

	// US006
	List<PostDTO> findAllPostsByUser(int id);
	List<PostDTO> sortedByAscAndDesc(int id, String order);

	void savePostPromo(PostPromoDTO postPromoDTO);
}
