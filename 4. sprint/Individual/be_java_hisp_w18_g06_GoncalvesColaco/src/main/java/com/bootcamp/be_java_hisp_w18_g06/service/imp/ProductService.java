package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PromoPostCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IPostService;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import com.bootcamp.be_java_hisp_w18_g06.service.IPromoPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IPostService postService;
	
	@Autowired
	private IPromoPostService promoPostService;

    @Override
    public void save(PostDTO postDTO) {
        postService.savePost(postDTO);
    }
	
	@Override
	public void createPromoPost(PromoPostDTO promoPostDTO) {
		promoPostService.createPromoPost(promoPostDTO);
	}
	
	// US006
	@Override
	public List<PostDTO> findAllPostsByUser(int id) {
		return postService.findAllPostsByUser(id);
	}
	@Override
	public List<PostDTO> sortedByAscAndDesc(int id, String order) {
		return postService.sortedByAscAndDesc(id,order);
	}
	
	@Override
	public PromoPostCountDTO countPromoPosts(int user_id) {
		return promoPostService.countPromoPosts(user_id);
	}
}
