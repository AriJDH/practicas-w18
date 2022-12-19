package api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class BookRequestDTO {
    private String id;
    private String author;
    private String name;
    private Integer pageQuantity;
    private String editorial;
    private Integer publicationYear;
}
