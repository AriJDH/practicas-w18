package com.sprint1.be_java_hisp_w18_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErroValidationrDto {
    private List<String> message;
    private Integer status;
    private LocalDateTime date;
}
