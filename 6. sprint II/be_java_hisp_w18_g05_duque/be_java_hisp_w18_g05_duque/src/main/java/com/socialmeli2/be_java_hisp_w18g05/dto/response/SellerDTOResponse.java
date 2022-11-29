package com.socialmeli2.be_java_hisp_w18g05.dto.response;

import com.socialmeli2.be_java_hisp_w18g05.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTOResponse {

    private Integer user_id;
    private String user_name;
    public SellerDTOResponse(Seller seller){
        this.user_id = seller.getUser_id();
        this.user_name = seller.getName();
    }
}
