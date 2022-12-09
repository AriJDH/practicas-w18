package com.example.hql2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoTotalDamageResponse {

    private List<VehiculoResponse> vehiculoResponseList;
    private Double perdidaEconomica;

}
