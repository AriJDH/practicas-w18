package com.bootcamp.be_java_hisp_w18_g06.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostResDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PromoResDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.Post;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.IPostService;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	public void savePromo(PostPromoDTO postPromoDTO) {
		//validar que exista el usuer_id en postPromoDTO

		int id = postPromoDTO.getUser_id();
		Optional<User> user = userRepository.findUserById(id);
		//si existe guardar postPromo, sino "el usuario no existe"

		if (user.isPresent()){
			postService.savePostPromo(postPromoDTO);
		}else {
			throw new BadRequestException("The user doesn't exits");
		}

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
	public PromoResDTO countPostWithPromoById(int userId) {
		//controla que exista el usuario que recibe por param
		//recorre la lista de posteos
		//controla que tengan promo en true: si es true lo suma a un contador
		//devuelve postResDto con el contador.

		Optional<User> user = userRepository.findUserById(userId);
		int counter = 0;

		if (user.isPresent()){
			//traigo la lista de posts
			List<Post> posts = user.get().getPosts();
			//la recorro
			for (Post post : posts) {
				if (post.isHas_promo()) {
					counter++;
				}
			}
		}else {
			throw new BadRequestException("The user doesn't exits");
		}

		int user_id = user.get().getUser_id();
		String user_name = user.get().getUser_name();

		return new PromoResDTO(user_id, user_name, counter);
	}
}
