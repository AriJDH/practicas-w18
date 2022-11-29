package com.sprint1.be_java_hisp_w18_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestPostDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El campo es obligatorio")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductRequestDTO product;

    @NotNull(message = "El campo category no puede estar vacio")
    private Integer category;

    @NotNull(message = "El campo price no puede estar vacio")
    @DecimalMax(value = "10000000.0", message = "El precio maximo por producto es 10000000")
    private Double price;

    private Boolean hasPromo;
    private Double discount;
}
