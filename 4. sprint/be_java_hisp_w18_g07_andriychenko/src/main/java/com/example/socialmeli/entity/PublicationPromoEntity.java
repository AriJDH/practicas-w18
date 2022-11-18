package com.example.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PublicationPromoEntity extends  PublicationEntity{
    private double discount;
}
