package com.socialmeli2.be_java_hisp_w18g05.dto.response;

import com.socialmeli2.be_java_hisp_w18g05.entity.Buyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDTOResponse {

    private Integer user_id;
    private String user_name;
    public BuyerDTOResponse(Buyer buyer){
        this.user_id = buyer.getUser_id();
        this.user_name = buyer.getName();
    }

}
