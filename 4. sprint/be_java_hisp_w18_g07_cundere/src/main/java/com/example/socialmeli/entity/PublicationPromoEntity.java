package com.example.socialmeli.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationPromoEntity extends PublicationEntity {

    private Boolean hasPromo;
    private Double discount;


    @Override
    public String toString() {
        return super.toString() +
                "hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }

}
