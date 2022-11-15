package com.meli.recapitulandospringp2vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class MetricDTO {
    private Integer id;
    private Integer numberRedirects;
}
