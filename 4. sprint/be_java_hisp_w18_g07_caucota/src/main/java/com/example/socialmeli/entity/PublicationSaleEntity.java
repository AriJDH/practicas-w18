package com.example.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class PublicationSaleEntity extends PublicationEntity {

    private Boolean hasPromo;
    private Double discount;

}
