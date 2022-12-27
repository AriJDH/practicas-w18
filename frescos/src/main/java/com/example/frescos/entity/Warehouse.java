package com.example.frescos.entity;

import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.extract.spi.SchemaExtractionException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long wareHouseCode;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="warehouse_code")
    private List<Section> sections = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Warehouse(List<Section> sections, Agent agent) {
        this.sections = sections;
        this.agent = agent;
    }

    public Warehouse(Agent agent){
        Section freshSection = new Section(SectionCode.FRESH);
        Section coolSection = new Section(SectionCode.COOL);
        Section frozenSection = new Section(SectionCode.FROZEN);
        this.sections.add(freshSection);
        this.sections.add(coolSection);
        this.sections.add(frozenSection);
        this.agent=agent;
    }

    public Section getSectionFromCode(Integer code){
        if(code<3)
            return sections.get(code);
        else
            throw new EntityNotFoundException("No existe una sección de código " + code);
    }
    public void addBatch(Integer sectionCode,  Batch batch){
        this.sections.get(sectionCode).addBatch(batch);
    }

}
