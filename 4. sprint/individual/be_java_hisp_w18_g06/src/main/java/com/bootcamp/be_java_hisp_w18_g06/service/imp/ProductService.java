package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserPromotionCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IPostService;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IPostService postService;

    @Override
    public void save(PostDTO postDTO) {
        postService.savePost(postDTO);
    }

	@Override
	public void savePromoPost(PromoPostDTO promoPostDTO) {
		postService.savePromoPost(promoPostDTO);
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
	public UserPromotionCountDTO countPromotionProducts(int id) { return postService.countPromotionProducts(id); }
}
