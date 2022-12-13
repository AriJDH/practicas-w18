package com.HQLHibernateQueryLanguagePG.HQLMySQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	private String title;
	private Integer number;
	@Column(name = "release_date")
	private Date releaseDate;
	@Column(name = "end_date")
	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "serie_id")
	private Serie serie;
	
}
