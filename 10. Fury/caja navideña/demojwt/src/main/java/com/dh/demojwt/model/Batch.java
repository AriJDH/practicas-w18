package com.dh.demojwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "batches")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "batch_number")
    private Integer batchNumber;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "current_temperature")
    private Double currentTemperature;

    @Column(name = "minimum_temperature")
    private Double minimumTemperature;

    @Column(name = "initial_quantity")
    private Integer initialQuantity;

    @Column(name = "current_quantity")
    private Integer currentQuantity;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "manufacturing_time")
    private LocalDateTime manufacturingTime;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "inbound_id", nullable = false)
    private InboundOrder inbound;

}
