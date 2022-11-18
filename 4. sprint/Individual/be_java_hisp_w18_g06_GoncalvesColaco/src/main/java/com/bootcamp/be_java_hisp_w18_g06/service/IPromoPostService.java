package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PromoPostCountDTO;

public interface IPromoPostService {
	
	void createPromoPost(PromoPostDTO promoPostDTO);
	PromoPostCountDTO countPromoPosts(int user_id);
}
