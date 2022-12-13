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
@Table(name = "movies")
public class Movie {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String title;
	Double rating;
	Integer awards;
	@Column(name = "release_date")
	Date releaseDate;
	Integer length;
	@Column(name = "genre_id")
	Integer genreId;
	
	@ManyToMany(mappedBy = "linkedMovies")
	@JsonIgnore
	Set<Actor> actors = new HashSet<>();
}
