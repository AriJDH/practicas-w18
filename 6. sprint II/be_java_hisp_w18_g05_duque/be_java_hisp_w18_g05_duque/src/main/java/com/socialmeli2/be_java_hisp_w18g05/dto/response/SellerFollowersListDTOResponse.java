package com.socialmeli2.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SellerFollowersListDTOResponse {

    private Integer user_id;
    private String user_name;
    private List<BuyerDTOResponse> followers;
}
