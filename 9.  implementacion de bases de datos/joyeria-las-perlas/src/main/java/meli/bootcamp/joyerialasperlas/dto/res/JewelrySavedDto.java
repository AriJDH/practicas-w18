package meli.bootcamp.joyerialasperlas.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JewelrySavedDto {
    private String message;
    private String status;
    private Long jewerlyId;
}
