package com.socialmedia2.be_java_hisp_w18_g08.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ProductDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDtoReq {
    @NotBlank(message = "El id_post no puede estar vacío.")
    @Min(value=0,message = "El id_post debe ser mayor a cero.")
    private Integer post_id;
    private Integer user_id;
    @Valid
    private ProductDto product;
    @NotBlank(message = "El campo no puede estar vacío.")
    private Integer category;
    @NotBlank(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10.000.000", message = "El precio máximo por producto es de 10.000.000")
    private Double price;
    @JsonFormat(pattern="dd-MM-yyyy")
    @NotBlank(message = "La fecha no puede estar vacía.")
    private LocalDate date;

}
