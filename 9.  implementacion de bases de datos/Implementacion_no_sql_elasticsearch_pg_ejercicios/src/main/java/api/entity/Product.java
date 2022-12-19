package api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "products")
public class Product {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;
    private String type;
    private Float priceOfSell;
    private Float priceOfCost;
    private Integer quantityAvailable;

}
