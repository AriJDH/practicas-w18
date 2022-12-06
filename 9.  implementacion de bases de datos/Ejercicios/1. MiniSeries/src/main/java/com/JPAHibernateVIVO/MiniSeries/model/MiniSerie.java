package com.JPAHibernateVIVO.MiniSeries.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class MiniSerie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Double rating;
	@Column(name = "amount_of_awards")
	private int amountOfAwards;
}
