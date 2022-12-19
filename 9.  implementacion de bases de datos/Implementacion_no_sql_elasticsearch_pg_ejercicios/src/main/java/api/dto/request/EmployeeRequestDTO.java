package api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class EmployeeRequestDTO {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String department;
}
