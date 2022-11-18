package com.sprint1.be_java_hisp_w18_g03.service;

import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseProductsCountDiscountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseProductsWithDiscountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;

public interface IPostService {
  ResponseDTO createPost(RequestPostDTO request);

  SellersPostDTO getPostSellers(Integer userId, String order);

  ResponseProductsCountDiscountDTO getCountProductsWithDiscount(
    Integer userId
  );

  ResponseProductsWithDiscountDTO getProductsWithDiscount(
    Integer userId
  );
  
}
