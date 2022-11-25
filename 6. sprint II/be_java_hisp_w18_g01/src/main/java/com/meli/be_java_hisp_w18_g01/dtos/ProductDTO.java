package com.meli.be_java_hisp_w18_g01.dtos;

import com.meli.be_java_hisp_w18_g01.utils.RegexFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "El id del producto no puede ser nulo.")

    @Min(value=1, message = "El id del producto debe ser mayor a 0.")
    private Long product_id;
    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Size(max = 40, message= "La longitud del nombre del producto no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Z]|[a-z]|[0-9]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ)[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ]*$", message = "El nombre del producto no puede contener caracteres especiales.")
    private String product_name;
    @NotBlank(message = "El tipo del producto no puede estar vacío.")
    @Size(max = 15, message= "La longitud del tipo del producto no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Z]|[a-z]|[0-9]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ)[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ]*$", message = "El tipo del producto no puede contener caracteres especiales.")
    private String type;
    private String brand;
    @NotBlank(message = "El color del producto no puede estar vacío.")
    @Size(max = 15, message= "La longitud del color del producto no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Z]|[a-z]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ)[\\s|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ]*$", message = "El color del producto no puede contener caracteres especiales.")
    private String color;
    @Size(max = 80, message= "Las notas del producto no pueden superar los 80 caracteres.")
    @Pattern(regexp = "([A-Z]|[a-z]|[0-9]|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ)[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|Ñ]*$", message = "Las notas del producto no pueden contener caracteres especiales.")
    private String notes;
}
