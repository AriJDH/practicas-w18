package com.mercadolibre.pf_be_java_hisp_w18_g1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class InboundOrder {
    @Id
    private Long orderNumber;
    private LocalDate orderDate;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Section section;
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "inbound_order_id")
    private List<Batch> batches;
    @ManyToOne
    @JoinColumn(name="agent_id")
    private Agent agent;

}
