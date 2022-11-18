package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;

import java.util.List;

public interface IPostService {

    void savePost(PostDTO postDTO);
	void savePromoPost(PostDTO postDTO);

	// US006
	List<PostDTO> findAllPostsByUser(int id);
	List<PostDTO> sortedByAscAndDesc(int id, String order);
}
