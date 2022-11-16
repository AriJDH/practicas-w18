package com.example.linktracker.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public class LinkDTOResp {

    private String link;
    private Boolean isValid;
}
