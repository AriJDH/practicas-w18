package com.example.socialmeli2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {

    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "El campo no puede estar vacío.")
    private LocalDate date;

    @Valid
    @JsonProperty("product")
    private ProductRequest productRequest;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000.0", message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}
