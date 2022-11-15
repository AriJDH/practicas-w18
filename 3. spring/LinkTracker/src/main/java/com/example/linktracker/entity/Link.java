package com.example.linktracker.entity;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Link {
    @NonNull
    private String url;
    private String pass;
    @NonNull
    private Long linkId;
    private Integer countMetrics = 0;

    public void sumarContador(){
        this.countMetrics++;
    }

}
