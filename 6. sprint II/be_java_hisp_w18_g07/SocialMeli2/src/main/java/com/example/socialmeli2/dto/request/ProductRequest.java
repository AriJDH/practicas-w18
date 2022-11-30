package com.example.socialmeli2.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    @JsonProperty("product_id")
    private Integer id;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[\\w À-ÿ]*", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String name;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[\\w À-ÿ]*", message = "El campo no puede poseer caracteres especiales")
    private String type;

    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[\\w À-ÿ]*", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[\\w À-ÿ]*", message = "El campo no puede poseer caracteres especiales.")
    private String notes;

}
