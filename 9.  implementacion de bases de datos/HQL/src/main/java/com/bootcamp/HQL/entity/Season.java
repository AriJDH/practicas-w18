package com.bootcamp.HQL.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    private String title;

    private Integer number;

    private LocalDate releaseDate;

    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Serie serie;
}
