package com.socialmeli.be_java_hisp_w18g05.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoSellerDTOResponse {

    Integer user_id;
    String user_name;
    Integer posts_count;
    double sum_of_posts_prices;
}
