package com.example.empresadeseguros.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ListPatMarcaVehiculosDTOResponse {
    private String mensaje;
    private List<PatMarcaVehiculosDTOResponse> patenteMarca;
}
