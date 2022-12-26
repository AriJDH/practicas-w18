package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionDbServiceImpl implements SectionDbService{
    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }
}
