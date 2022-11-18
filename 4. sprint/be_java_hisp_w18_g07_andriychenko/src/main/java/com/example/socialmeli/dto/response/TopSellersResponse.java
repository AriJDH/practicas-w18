package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class TopSellersResponse {
    @JsonProperty("top_promo_post")
    private Integer topPromoPost;
    @JsonProperty("top_sellers")
    private List<UserBasicResponse> topSellers;
}
