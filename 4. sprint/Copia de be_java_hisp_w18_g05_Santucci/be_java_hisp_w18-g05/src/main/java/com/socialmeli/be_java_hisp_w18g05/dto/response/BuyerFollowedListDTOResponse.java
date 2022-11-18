package com.socialmeli.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerFollowedListDTOResponse {
    private Integer user_id;
    private String user_name;
    private List<SellerDTOResponse> followed;
}
