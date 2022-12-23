package com.example.melifrescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long wareHouseCode;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "warehouse")
    private List<Section> sections;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
