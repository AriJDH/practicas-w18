package com.sprint1.be_java_hisp_w18_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequestDTO {
  @JsonProperty("product_id")
  @NotNull(message = "El id no puede estar vacio")
  @Min(value = 1, message = "El id debe ser mayor a 0")
  private Integer productId;

  @JsonProperty("product_name")
  @NotBlank(message = "El nombre del producto no debe estar vacio")
  @Size(max = 40, message = "La longitud de productName no puede superar los 40 caracteres")
  @Pattern(regexp="^([\\w]*[\\s]*)*$", message = "El campo no puede poseer caracteres especiales")
  private String productName;

  @NotBlank(message = "El nombre del producto no debe estar vacio")
  @Size(max = 15, message = "La longitud de type no puede superar los 15 caracteres")
  @Pattern(regexp="^[\\w]+$", message = "El campo no puede poseer caracteres especiales")
  private String type;

  private String brand;

  @Pattern(regexp="^[\\w]+$", message = "El campo no puede poseer caracteres especiales")
  @NotBlank(message = "El color del producto no debe estar vacio")
  @Size(max = 15, message = "La longitud de color no puede superar los 15 caracteres")
  private String color;

  @Size(max = 80, message = "La longitud de notes no puede superar los 80 caracteres")
  @Pattern(regexp="^([\\w]*[\\s]*)*$", message = "El campo no puede poseer caracteres especiales")
  private String notes;

  private Boolean hasPromo;
  private Double discount;
}
