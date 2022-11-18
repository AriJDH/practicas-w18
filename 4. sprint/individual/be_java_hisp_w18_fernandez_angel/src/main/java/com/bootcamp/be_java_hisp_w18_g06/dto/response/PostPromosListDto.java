package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostPromosListDto {
    List<PostPromoAllDto>posts;
}
