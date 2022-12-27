package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.enums.SectionCode;


public interface SectionDbService {
    Section save(Section section);
    Section findBySectionCode(SectionCode sectionCode);
}
