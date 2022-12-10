package com.example.hql_asincronico.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer favorite_movie_id;
    private Double rating;
    private Timestamp created_at;
    private Timestamp updated_at;

}
