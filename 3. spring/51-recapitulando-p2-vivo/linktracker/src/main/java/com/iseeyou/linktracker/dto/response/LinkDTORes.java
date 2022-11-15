package com.iseeyou.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkDTORes {
    private Integer linkId;
    private String url;
    private Integer contador;
    private String password;
}
