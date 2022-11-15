package meli.bootcamp.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String mensaje;
    private int status;
}
