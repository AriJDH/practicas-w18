package com.HQLHibernateQueryLanguagePG.HQLMySQL.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "actors")
public class Actor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	String firstName;
	String lastName;
	Double rating;
	@Column(name = "favorite_movie_id") Integer favoriteMovieId;
	@ManyToMany
	@JoinTable(name = "actor_movie",
					joinColumns = @JoinColumn(name = "actor_id"),
					inverseJoinColumns = @JoinColumn(name = "movie_id")) Set<Movie> linkedMovies = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "actor_episode",
					joinColumns = @JoinColumn(name = "actor_id"),
					inverseJoinColumns = @JoinColumn(name = "episode_id")) Set<Episode> linkedEpisodes = new HashSet<>();
}
