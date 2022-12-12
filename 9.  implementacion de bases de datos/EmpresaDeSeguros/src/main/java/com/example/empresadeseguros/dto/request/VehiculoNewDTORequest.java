package com.example.empresadeseguros.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoNewDTORequest {
    @NotNull( message = "La patente no puede ser nulo")
    private String patente;
    @NotNull( message = "La marca no puede ser nulo")
    private String marca;
    @NotNull( message = "El modelo no puede ser nulo")
    private String modelo;
    @NotNull( message = "El anio no puede ser nulo")
    @Min(value = 1900, message = "El año no puede ser menor a 1900")
    private Integer anio;
    @NotNull( message = "La cantidad de ruedas no puede ser nulo")
    @Min(value = 2, message = "La cantidad de ruedas no puede ser menor a 2")
    private Integer ruedas;
}
