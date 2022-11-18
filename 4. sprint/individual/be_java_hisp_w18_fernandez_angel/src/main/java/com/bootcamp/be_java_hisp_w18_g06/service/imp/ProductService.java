package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromoResDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromosListDto;
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
	public void savePromoPost(PostPromoDto postPromoDto) {
		postService.savePromoPost(postPromoDto);
	}

	@Override
	public PostPromoResDto countProductInPromoByUserId(int userId) {
		return postService.countProductInPromoByUserId(userId);
	}

	@Override
	public PostPromosListDto findPromos(String discount) {
		return postService.findPromos(discount);
	}
}
