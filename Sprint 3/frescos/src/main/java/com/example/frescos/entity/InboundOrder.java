package com.example.frescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "inbound_order_id")
    private List<Batch> batches;
    @ManyToOne
    @JoinColumn(name="agent_id")
    private Agent agent;

}
