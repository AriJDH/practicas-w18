package api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private Integer pageQuantity;
    private String editorial;
    private Integer publicationYear;
}
