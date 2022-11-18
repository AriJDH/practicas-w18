package com.mercadolibre.linktracker.entity;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Link {
    @NonNull
    private Long linkId;
    @NonNull
    private String link;
    @NonNull
    private String password;

    private boolean enabled = true;
    private Integer redirects = 0;
}
