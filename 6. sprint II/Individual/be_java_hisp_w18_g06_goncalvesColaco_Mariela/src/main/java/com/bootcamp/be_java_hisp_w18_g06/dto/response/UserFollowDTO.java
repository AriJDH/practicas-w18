package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserFollowDTO {
	@JsonProperty("user_id")
	private Integer userId;
	@JsonProperty("user_name")
	private String userName;
}
