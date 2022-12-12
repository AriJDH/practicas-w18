package com.example.empresadeseguros.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListMMMVehiculoDTOResponse {
    private String mensaje;
    private List<MMMVehiculoDTOResponse> vehiculos;
}
