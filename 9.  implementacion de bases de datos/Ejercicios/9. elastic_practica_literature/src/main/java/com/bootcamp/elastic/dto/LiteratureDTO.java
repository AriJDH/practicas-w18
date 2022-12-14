package com.bootcamp.elastic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LiteratureDTO {
	private String id;
	private String title;
	private String author;
	@JsonProperty("cant_pages")
	private Integer cantPages;
	private String editorial;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate firstPost;
}
