package spring.autos.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int kilometers;
    private String description;
}
