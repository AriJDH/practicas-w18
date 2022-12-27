package com.example.frescos.service;

import com.example.frescos.comparators.LocalDateComparatorAsc;
import com.example.frescos.comparators.LocalDateComparatorDesc;
import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.repository.BatchRepository;
import com.example.frescos.security.AuthorizationManager;
import com.example.frescos.service.db.BatchDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchServiceImp implements BatchService {
    @Autowired
    private BatchDbService batchDbService;

    @Override
    public List<BatchResponseDTO> getAllBatches(Authentication authentication, Integer amountDays, String category, String order) {
        List<Batch> batches = batchDbService.getAllBatches();

        batches = batches.stream().filter(b -> {
            Long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), b.getDueDate());
            return (daysBetween <= amountDays.longValue());
        }).collect(Collectors.toList());

        if(category != null){
            switch (category) {
                case "FS": //FS es fresco
                    batches = batches.stream().filter(b -> b.getProduct().getSectionCode().equals(SectionCode.FRESH)).collect(Collectors.toList());
                    break;
                case "RF": //RF es refrigerado
                    batches = batches.stream().filter(b -> b.getProduct().getSectionCode().equals(SectionCode.COOL)).collect(Collectors.toList());

                    break;
                case "FF": //FF es congelado
                    batches = batches.stream().filter(b -> b.getProduct().getSectionCode().equals(SectionCode.FROZEN)).collect(Collectors.toList());
                    break;
                default:
                    throw new BadRequestException("El parámetro " + category + " es inválido.");
            }
        }

        if (order != null){
        Comparator comp;
            switch (order) {
                case "date_asc":
                    comp = new LocalDateComparatorAsc();
                    break;
                case "date_desc":
                    comp = new LocalDateComparatorDesc();
                    break;
                default:
                    throw new BadRequestException("El parámetro " + order + " es inválido.");
            }
            batches.sort((p1, p2) -> comp.compare(p1.getDueDate(), p2.getDueDate()));
        }

        List<BatchResponseDTO> batchResponseDTOS= batches.stream().map(b -> new BatchResponseDTO(b.getBatchNumber(),b.getProduct().getId(),b.getProduct().getSectionCode().getCode(),b.getDueDate(),b.getCurrentQuantity())).collect(Collectors.toList());

        return batchResponseDTOS;
    }
}
