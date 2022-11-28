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
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "(_/[A-Z]/[a-z]/[0-9]*$)", message = "El campo no puede poseer caracteres especiales.")
    private String product_name;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "(_/[A-Z]/[a-z]/[0-9]*$)", message = "El campo no puede poseer caracteres especiales.")
    private String type;
    private String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "(_/[A-Z]/[a-z]/[0-9]*$)", message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Z]/[a-z]/[0-9]*$)", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
