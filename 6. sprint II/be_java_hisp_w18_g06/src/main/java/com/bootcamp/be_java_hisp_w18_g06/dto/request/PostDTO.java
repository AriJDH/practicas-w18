package com.bootcamp.be_java_hisp_w18_g06.dto.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class PostDTO {
    //US-005
    @NotNull(message = "Id cannot be empty")
    @Min(value = 1, message = "Id must be greater than 0")
    private Integer user_id;
    @NotNull(message = "Date cannot be empty")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotNull(message = "Product cannot be empty")
    @Valid
    private ProductReqDTO product;
    @NotBlank(message = "Category field cannot be empty")
    private String category;
    @NotNull(message = "Price field cannot be empty")
    @Max(value = 10000000, message = "Price cannot be higher than $ 10.000.000")
    private Double price;
}
