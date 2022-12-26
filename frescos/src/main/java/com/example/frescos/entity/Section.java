package com.example.frescos.entity;

import com.example.frescos.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private SectionCode sectionCode;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "section_id")
    private List<Batch> batches = new ArrayList<>();
    private Integer availableBatchSpace = 100;

    public Section(SectionCode sectionCode, List<Batch> batches, Integer availableBatchSpace) {
        this.sectionCode = sectionCode;
        this.batches = batches;
        this.availableBatchSpace = availableBatchSpace;
    }

    public Section(SectionCode sectionCode, List<Batch> batches) {
        this.sectionCode = sectionCode;
        this.batches = batches;
    }
    public Section(SectionCode sectionCode) {
        this.sectionCode = sectionCode;
    }
}
