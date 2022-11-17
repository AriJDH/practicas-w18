package com.linktracker.linktracker.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkResDTO {
    private Integer linkId;
    private String link;
    private Integer count;
}
