package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.enums.SectionCode;

import java.util.List;


public interface SectionDbService {
    Section save(Section section);
    List<Section> findAllBySectionCode(SectionCode sectionCode);
}
