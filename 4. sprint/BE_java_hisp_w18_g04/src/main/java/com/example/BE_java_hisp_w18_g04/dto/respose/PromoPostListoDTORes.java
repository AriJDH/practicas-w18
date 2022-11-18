package com.example.BE_java_hisp_w18_g04.dto.respose;

import com.example.BE_java_hisp_w18_g04.dto.request.PromoPostDTOReq;
import com.example.BE_java_hisp_w18_g04.entity.PostPromo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoPostListoDTORes {
    private Integer user_id;
    private String user_name;
    private List<PostPromo> posts;
}
