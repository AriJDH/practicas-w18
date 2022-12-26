package com.example.frescos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer sectionCode;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "section_id")
    private List<Batch> batches;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "warehouse_code")
    private Warehouse warehouse;
    private Integer availableBatchSpace;
}
