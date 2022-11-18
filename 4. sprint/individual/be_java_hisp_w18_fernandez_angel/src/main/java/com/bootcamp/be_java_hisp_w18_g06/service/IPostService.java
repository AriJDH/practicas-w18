package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromoResDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromosListDto;

import java.util.List;

public interface IPostService {

    void savePost(PostDTO postDTO);

	// US006
	List<PostDTO> findAllPostsByUser(int id);
	List<PostDTO> sortedByAscAndDesc(int id, String order);
	void savePromoPost(PostPromoDto postPromoDto);
	PostPromoResDto countProductInPromoByUserId(int userId);

	PostPromosListDto findPromos(String discount);
}
