package com.socialmeli.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPromoPostListDTOResponse {
    private Integer user_id;
    private List<PromoPostDTOResponse> posts;
}
