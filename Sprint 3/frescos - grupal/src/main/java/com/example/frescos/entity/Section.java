package com.example.frescos.entity;

import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.FullSectionException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @OneToMany(cascade = {CascadeType.MERGE}, orphanRemoval = true)
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

    public void addBatch(Batch batch){
        if(this.batches.size()+1<this.availableBatchSpace){
            this.batches.add(batch);
            this.availableBatchSpace--;
        }
        else
            throw new FullSectionException("La sección alcanzó su capacidad máxima");
    }

    public void removeBatchByBatchNumber(Long batchNumber){
        Optional<Batch> optBatch = batches.stream().filter(b->b.getBatchNumber().equals(batchNumber)).findFirst();
        if(optBatch.isPresent()){
            this.batches.remove(optBatch.get());
            this.availableBatchSpace++;
        }
    }
    public boolean containsSpace(int space){
        return space <= this.availableBatchSpace.intValue();
    }
}
