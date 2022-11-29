package com.socialmeli.be_java_hisp_w18g05.dto.response;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerFollowersCountDTOResponse {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
