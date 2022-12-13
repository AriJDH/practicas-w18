package com.HQLHibernateQueryLanguagePG.HQLMySQL.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class EpisodeDTO {
	
	private Integer id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	private String title;
	private Integer number;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date releaseDate;
	private Double rating;
	private Integer seasonId;
	
}
