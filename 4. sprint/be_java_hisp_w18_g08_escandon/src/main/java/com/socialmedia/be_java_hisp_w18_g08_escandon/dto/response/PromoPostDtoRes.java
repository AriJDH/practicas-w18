package com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.PostDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.PromoPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromoPostDtoRes {
    private Integer user_id;
    private String user_name;
    private List<PromoPostDto> posts;
}
