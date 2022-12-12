package com.example.empresadeseguros.dto.request;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroNewDTORequest {

    @NotNull( message = "La fecha no puede ser nula")
    private LocalDate fecha;

    @NotNull( message = "La pérdida económica no puede ser nula")
    @DecimalMin(value = "0", message = "La pérdida económica no puede ser negativa")
    private Double perdidaEconomica;

    @NotNull( message = "El id del vehículo no puede ser nulo")
    @Min(value = 1, message = "El id del vehículo debe ser mayor a 0")
    private Integer vehiculo_id;
}
