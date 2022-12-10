package com.example.empresadeseguros.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatentesVehiculosDTOResponse {
    private String mensaje;
    private List<String> patente;

}
