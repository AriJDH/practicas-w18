package com.example.BE_java_hisp_w18_g04.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FollowerListDTORes {
    private Integer user_id;
    private String user_name;
    private List<UserDTORes> followers;
}
