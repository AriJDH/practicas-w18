package com.dh.demojwt.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inbound_orders")
public class InboundOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @OneToMany(mappedBy = "inbound", cascade = CascadeType.ALL)
    private Set<Batch> batchStock;

}
