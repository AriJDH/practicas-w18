package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FoodDTO {

    private String name;

    private Integer calories;
}
