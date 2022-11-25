package com.dh.be_java_hisp_w18_g10.dto.require;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOreq {

    private final String NOT_SPECIAL_CHARACTERS_PATTERN = "[^&%$#@!~]*";

    @NotNull(message = "El id no puede estar vacio.")
    @Min(value=1, message = "El id debe ser mayor a cero")
    private int product_id;

    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max=40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = NOT_SPECIAL_CHARACTERS_PATTERN, message = "El campo no puede poseer caracteres especiales. Nombre Producto")
    private String product_name;

    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = NOT_SPECIAL_CHARACTERS_PATTERN, message = "El campo no puede poseer caracteres especiales. Tipo")
    private String type;

    private String brand;


    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = NOT_SPECIAL_CHARACTERS_PATTERN, message = "El campo no puede poseer caracteres especiales. Color")
    private String color;

    @NotEmpty(message = "El campo no puede estar vacio.")
    @Size(max=80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = NOT_SPECIAL_CHARACTERS_PATTERN, message = "El campo no puede poseer caracteres especiales. Notas")
    private String notes;



}
