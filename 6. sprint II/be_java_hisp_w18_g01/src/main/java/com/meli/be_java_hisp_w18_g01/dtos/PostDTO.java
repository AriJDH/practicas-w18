package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @NotNull(message = "El id del usuario no puede ser nulo.")
    @Min(value=1, message = "El id del usuario debe ser mayor a 0.")
    private Long user_id;
    @NotBlank(message = "El campo de la facha no puede estar vacío.")
    private String date;
    @Valid
    private ProductDTO product;
    @NotNull(message = "La categoria no puede estar vacía.")
    private Integer category;
    @NotNull(message = "El precio no puede estar vacío.")
    @Max(value = 10_000_000)
    private Double price;
}
