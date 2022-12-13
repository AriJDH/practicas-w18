package com.example.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Document(indexName = "employees")
public class Employee {

	@Id private String id; // Recomendable que sea String
	private String name;
	private String lastname;
	private Integer age;
	private String city;
	private String province;
	
	public void setId(String id) {
	this.id = id;
	}
}
