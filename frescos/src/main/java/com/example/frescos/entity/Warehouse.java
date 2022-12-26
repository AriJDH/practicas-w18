package com.example.frescos.entity;

import com.example.frescos.enums.SectionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
