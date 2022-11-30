package com.socialmedia2.be_java_hisp_w18_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer product_id;
    @NotBlank(message = "El prodcutName no puede estar vacío.")
    @Size(max = 40, message = "La longitud del prodcutName no puede superar los 40 caracteres.")
    @Pattern(regexp = "[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El productName no puede poseer caracteres especiales.")
    private String product_name;
    @NotBlank(message = "El campo type no puede estar vacío.")
    @Size(max = 15, message = "La longitud del campo type no puede superar los 40 caracteres.")
    @Pattern(regexp = "[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El type no puede poseer caracteres especiales.")
    private String type;
    private String brand;
    @NotBlank(message = "El campo color no puede estar vacío.")
    @Size(max = 15, message = "La longitud del campo color no puede superar los 40 caracteres.")
    @Pattern(regexp = "[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El Color no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud del campo notas no puede superar los 40 caracteres.")
    @Pattern(regexp = "[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El campo notas no puede poseer caracteres especiales.")
    private String notes;
}
