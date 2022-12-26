package com.example.frescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InboundOrder {
    @Id
    private Long orderNumber;
    private LocalDate orderDate;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Section section;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Batch batch;
}
