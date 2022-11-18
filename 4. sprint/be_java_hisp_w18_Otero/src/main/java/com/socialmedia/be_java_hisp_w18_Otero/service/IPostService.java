package com.socialmedia.be_java_hisp_w18_Otero.service;

import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.PostPromoDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PostDtoRes;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.PromoPostCountDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.RankingLikesDto;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Post;

public interface IPostService {

    void createPost(PostDtoReq postDTOReq);

    PostDtoRes getPostSellerListByUserId(Integer id, String order);

    Post createPromoPost(PostPromoDtoReq post);

    PromoPostCountDto getPromoPostCountBySeller(Integer userId);

    void AddlikeToPost(Integer post_id);

    RankingLikesDto getRankingLikes(String order);
}
