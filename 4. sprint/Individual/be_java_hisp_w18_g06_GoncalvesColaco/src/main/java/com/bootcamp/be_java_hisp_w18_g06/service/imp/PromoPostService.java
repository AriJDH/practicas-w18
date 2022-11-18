package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PromoPostCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.PromoPost;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IPromoPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoPostService implements IPromoPostService {
	
	@Autowired
	private IUserRepository userRepository;
	
	// Mapeo -> No modificar por el momento!
	ObjectMapper mapper = JsonMapper.builder()
					.findAndAddModules()
					.build();
	
	@Override
	public void createPromoPost(PromoPostDTO promoPostDTO) {
		// TODO refactorizar cuando tengamos certeza de la mejor opción
		PromoPost promoPost = mapper.convertValue(promoPostDTO, PromoPost.class);
		userRepository.createPromoPost(promoPost);
	}
	
	@Override
	public PromoPostCountDTO countPromoPosts(int user_id){
		User user = userRepository.findUserById(user_id)
						.orElseThrow(()-> new NotFoundException("Not found"));
		int postsPromoCount =  user.getPromoPosts().size();
		return new PromoPostCountDTO(user_id, user.getUser_name(),
						postsPromoCount);
	}
}
