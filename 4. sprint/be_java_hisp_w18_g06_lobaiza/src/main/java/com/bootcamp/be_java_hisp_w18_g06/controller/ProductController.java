package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserPromoPostCountDTO;
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
	public ResponseEntity<?> savePromo(@RequestBody PostPromoDTO postPromoDTO) {
		productService.savePromo(postPromoDTO, postPromoDTO.getUser_id());
		return ResponseEntity.ok("OK");
	}

	@GetMapping("promo-post/count")
	public ResponseEntity<?> countPromoPost(@RequestParam int userId) {
		UserPromoPostCountDTO userPromoPostCountDTO = productService.countPromo(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userPromoPostCountDTO);
	}

}
