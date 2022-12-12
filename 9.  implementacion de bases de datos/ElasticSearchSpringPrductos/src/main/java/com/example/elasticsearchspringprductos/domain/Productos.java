package com.example.elasticsearchspringprductos.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@Document(indexName = "segundo")
public class Productos {

    @Id
    private String id;

    private String name;

    private Precio myPrice;


}
/*
 {
  "id": "",
  "name": "",
  "myPrice": {
    "id": "",
    "price": 0.0
  }
}
*/