package com.example.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationPromoEntity extends PublicationEntity {
    private Boolean hasPromo;
    private Double discount;
}
