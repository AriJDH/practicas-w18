package com.dh.relacionesjpa.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter
@ToString @RequiredArgsConstructor
@Entity
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "accident_date")
    private LocalDate accidentDate;

    @Column(name = "economic_loss")
    private Double economicLoss;

    @Column(name = "vehicle_id")
    private Long vehicleId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sinister claim = (Sinister) o;
        return id != null && Objects.equals(id, claim.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
