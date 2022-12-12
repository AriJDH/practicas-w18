package com.example.empresadeseguros.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListMMMVehiculoTotalDTOResponse {
    private String mensaje;
    private Double perdidaTotal;
    private List<MMMVehiculoDTOResponse> vehiculos;
}
