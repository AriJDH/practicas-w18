package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
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
	public List<PostDTO> findAllPostsByUser(int id,String order) {
		return postService.findAllPostsByUser(id,order);
	}
}
