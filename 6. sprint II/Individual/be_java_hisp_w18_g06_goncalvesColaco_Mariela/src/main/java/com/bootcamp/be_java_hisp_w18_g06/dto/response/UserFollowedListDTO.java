package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserFollowedListDTO {
	//US-OO4
	@JsonProperty("user_id")
	private Integer userId;
	@JsonProperty("user_name")
	private String userName;
	private List<UserFollowDTO> followed = new ArrayList<>();
}
