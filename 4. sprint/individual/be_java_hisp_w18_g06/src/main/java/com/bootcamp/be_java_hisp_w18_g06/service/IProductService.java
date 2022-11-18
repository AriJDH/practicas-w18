package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserPromotionCountDTO;

import java.util.List;

public interface IProductService {

    void save(PostDTO postDTO);
    void savePromoPost(PostDTO postDTO);

	// US006
	List<PostDTO> findAllPostsByUser(int id);
	List<PostDTO> sortedByAscAndDesc(int id, String order);

	UserPromotionCountDTO countPromotionProducts(int id);
}
