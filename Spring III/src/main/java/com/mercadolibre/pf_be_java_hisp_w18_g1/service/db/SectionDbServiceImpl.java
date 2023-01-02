package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionDbServiceImpl implements SectionDbService{
    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> findAllBySectionCode(SectionCode sectionCode) {
        return sectionRepository.findAllBySectionCode(sectionCode);
    }
}
