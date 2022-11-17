package com.linktracker.linktracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;
}
