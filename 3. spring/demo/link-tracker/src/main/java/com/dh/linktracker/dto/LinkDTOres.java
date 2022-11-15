package com.dh.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTOres {
    private Integer id;
    private String url;
    private Boolean isValidURL;
}
