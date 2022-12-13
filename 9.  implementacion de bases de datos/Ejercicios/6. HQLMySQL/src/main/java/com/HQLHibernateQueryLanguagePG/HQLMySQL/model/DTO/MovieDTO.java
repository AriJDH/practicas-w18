package com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieDTO {
	
	private Integer id;
	private String title;
	private Double rating;
	private Integer awards;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	private Integer length;
	private Integer genreId;
}
