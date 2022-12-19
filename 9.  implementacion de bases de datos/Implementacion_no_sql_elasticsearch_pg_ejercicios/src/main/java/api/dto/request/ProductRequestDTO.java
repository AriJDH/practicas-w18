package api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ProductRequestDTO {
    private String id;
    private String name;
    private String type;
    private Float priceOfSell;
    private Float priceOfCost;
    private Integer quantityAvailable;
}
