package com.mercadolibre.Elastic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private Integer age;
    private String city;
    private String province;
}


