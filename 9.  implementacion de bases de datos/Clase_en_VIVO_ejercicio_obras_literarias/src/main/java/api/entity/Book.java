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
@Document(indexName = "books")
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String author;
    private String name;
    private String editorial;
    private Integer pageQuantity;
    private Integer publicationYear;
}
