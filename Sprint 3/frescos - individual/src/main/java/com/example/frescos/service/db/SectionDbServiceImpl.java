package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.SectionRepository;
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
