package com.socialmeli.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AllBuyersDTOResponse {
    List<BuyerDTOResponse> responseList;
}
