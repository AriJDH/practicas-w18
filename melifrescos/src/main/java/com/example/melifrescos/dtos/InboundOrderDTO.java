package com.example.melifrescos.dtos;

import java.time.LocalDate;
import java.util.List;

public class InboundOrderDTO {
    private Long orderNumber;
    private LocalDate orderDate;
    private SectionDTO sectionDTO;
    private List<BatchDTO> batchesDTO;
}
