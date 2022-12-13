package com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SerieDTO {
	private Integer id;
	private Date createdAt;
	private Date updatedAt;
	private String title;
	private Date releaseDate;
	private Date endDate;
	private Integer genreId;
}
