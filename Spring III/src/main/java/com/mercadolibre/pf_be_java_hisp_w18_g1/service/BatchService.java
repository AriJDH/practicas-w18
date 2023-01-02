package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.BatchResponseDTO;
import org.springframework.security.core.Authentication;


import java.util.List;

public interface BatchService {

    List<BatchResponseDTO> getAllBatches(Authentication authentication, Integer amountDays, String category, String order );
}
