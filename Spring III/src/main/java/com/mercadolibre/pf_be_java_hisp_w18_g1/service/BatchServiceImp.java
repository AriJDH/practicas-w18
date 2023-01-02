package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.comparators.LocalDateComparatorAsc;
import com.mercadolibre.pf_be_java_hisp_w18_g1.comparators.LocalDateComparatorDesc;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.BatchResponseDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Batch;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.BadRequestException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.BatchDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BatchServiceImp implements BatchService {
    @Autowired
    private BatchDbService batchDbService;

    @Override
    public List<BatchResponseDTO> getAllBatches(Authentication authentication, Integer amountDays, String category, String order) {

        if(amountDays < 0)
            throw new BadRequestException("La cantidad de dias debe ser mayor o igual a cero");

        List<Batch> batches = batchDbService.getAllBatches();

        batches = batches.stream().filter(b -> {
            Long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), b.getDueDate());
            return ( ( (b.getDueDate().compareTo(LocalDate.now()) > 0)  || (b.getDueDate().compareTo(LocalDate.now()) == 0) ) && (daysBetween <= amountDays.longValue()) );
        }).collect(Collectors.toList());

        if(category != null){
            switch (category) {
                case "FS":
                case "Fs":
                case "fS":
                case "fs": //FS es fresco (0)
                    batches = batches.stream().filter(b -> b.getProduct().getSectionCode().equals(SectionCode.FRESH)).collect(Collectors.toList());
                    break;

                case "RF":
                case "Rf":
                case "rF":
                case "rf": //RF es refrigerado (1)
                    batches = batches.stream().filter(b -> b.getProduct().getSectionCode().equals(SectionCode.COOL)).collect(Collectors.toList());

                    break;
                case "FF":
                case "Ff":
                case "fF":
                case "ff": //FF es congelado (2)
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
