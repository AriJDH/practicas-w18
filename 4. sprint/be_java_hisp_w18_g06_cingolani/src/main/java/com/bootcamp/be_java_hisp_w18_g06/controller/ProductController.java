package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.MessageDTO;
import com.bootcamp.be_java_hisp_w18_g06.service.IPostService;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IPostService postService;

	// US006
	@GetMapping("/followed/{userId}/list")
	public ResponseEntity<List<PostDTO>> findAllByUser(@PathVariable int userId,
                                                       @RequestParam(required = false) String order) {
	    if(order!=null)
	        return ResponseEntity.ok(productService.sortedByAscAndDesc(userId,order));

		return ResponseEntity.ok(productService.findAllPostsByUser(userId));
	}

    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody PostDTO postDTO){
        productService.save(postDTO);
        return ResponseEntity.ok("OK");
    }


	//US 0010
	@PostMapping("/promo-post")
	public ResponseEntity<MessageDTO> postPromo(@RequestBody PostPromoDTO postPromoDTO){
		postService.savePostPromo(postPromoDTO);
		return new ResponseEntity<>(new MessageDTO("Add Post Promo"), HttpStatus.CREATED);
	}

	/*
	*
	* US 0010 - PROPUESTA DE MEJORA: Cambio status de respuesta de 200 a 201 y agrego mensaje
	* Status Code 201 (CREATED) - Message("Add Post Promo)
	*
	*/


	//US 0011
	@GetMapping("/promo-post/count")
	public ResponseEntity<?> getPostPromoBySeller(@RequestParam int user_id){
		return new ResponseEntity<>(postService.countPostPromo(user_id), HttpStatus.OK);
	}

}
