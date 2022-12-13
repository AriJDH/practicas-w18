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
@Table(name = "episodes")
public class Episode {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@Column(name = "created_at") private Date createdAt;
	@Column(name = "updated_at") private Date updatedAt;
	private String title;
	private Integer number;
	@Column(name = "release_date") private Date releaseDate;
	private Double rating;
	@Column(name = "season_id") private Integer seasonId;
	@ManyToMany(mappedBy = "linkedEpisodes") @JsonIgnore Set<Actor> actors = new HashSet<>();
	
}

