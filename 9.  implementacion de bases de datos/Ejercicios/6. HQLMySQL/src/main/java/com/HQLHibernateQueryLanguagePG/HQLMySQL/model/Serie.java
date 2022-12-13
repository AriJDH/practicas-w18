package com.HQLHibernateQueryLanguagePG.HQLMySQL.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "series")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	private String title;
	@Column(name = "release_date")
	private Date releaseDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "genre_id")
	private Integer genreId;
	@OneToMany(mappedBy = "serie")
	@JsonIgnore
	private Set<Season> seasons = new HashSet<>();
	
}
