package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserPromotionCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	// US006
	@GetMapping("/followed/{userId}/list")
	public ResponseEntity<List<PostDTO>> findAllByUser(@PathVariable int userId,
                                                       @RequestParam(required = false) String order) {
	    if(order!=null)
	        return ResponseEntity.ok(productService.sortedByAscAndDesc(userId,order));

		return ResponseEntity.ok(productService.findAllPostsByUser(userId));
	}

    @PostMapping("/post")
    public ResponseEntity<?> save(PostDTO postDTO){
        productService.save(postDTO);
        return ResponseEntity.ok("OK");
    }

	@PostMapping("/promo-post")
	public ResponseEntity<?> savePromoPost(@RequestBody PostDTO postDTO){
		productService.savePromoPost(postDTO);
		return ResponseEntity.ok("OK");
	}

	@GetMapping("/promo-post/count")
	public ResponseEntity<?> countPromotionProducts(@PathVariable int userId){
		UserPromotionCountDTO userPromotionCountDTO = productService.countPromotionProducts(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userPromotionCountDTO);
	}

}
