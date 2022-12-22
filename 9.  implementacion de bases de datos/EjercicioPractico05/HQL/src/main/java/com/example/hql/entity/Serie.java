package com.example.hql.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
