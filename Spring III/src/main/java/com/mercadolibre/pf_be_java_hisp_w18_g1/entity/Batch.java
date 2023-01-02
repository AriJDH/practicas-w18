package com.mercadolibre.pf_be_java_hisp_w18_g1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Batch {
    @Id
    private Long batchNumber;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    private Product product;
    private Double currentTemperature;
    private Double minimumTemperature;
    private Integer initialQuantity;
    private Integer currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingTime;
    private LocalDate dueDate;

    public Boolean isDueDateOk(LocalDate ref){
        return DAYS.between(ref, this.dueDate)>=21;
    }

}