package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;


import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;

import java.util.List;

public interface SectionDbService {
    Section save(Section section);
    List<Section> findAllBySectionCode(SectionCode sectionCode);
}
