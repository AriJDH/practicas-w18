package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostPromoDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromoResDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.PostPromosListDto;
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
    public ResponseEntity<?> save(@RequestBody PostDTO postDTO){
        productService.save(postDTO);
        return ResponseEntity.ok("OK");
    }
	@PostMapping("/promo-post")
	public ResponseEntity<?> savePromoPost(@RequestBody PostPromoDto postDTO){
		productService.savePromoPost(postDTO);
		return ResponseEntity.ok("OK");
	}
	@GetMapping("/promo-post/count")
	public ResponseEntity<PostPromoResDto> countPromoPost(@RequestParam("user_id") int user_id){
		return new ResponseEntity<>(productService.countProductInPromoByUserId(user_id), HttpStatus.OK);
	}
	@GetMapping("/promos/list")
	public ResponseEntity<PostPromosListDto> findPromos(@RequestParam(required = false) String discount){
		return new ResponseEntity<>(productService.findPromos(discount), HttpStatus.OK);
	}
}
