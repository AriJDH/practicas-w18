package com.example.linktracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkMetricsDTO {
    private long id;
    private int redirectionCount;
}
