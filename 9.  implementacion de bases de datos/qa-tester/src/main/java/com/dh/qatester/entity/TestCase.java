package com.dh.qatester.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter @Setter
@ToString
@RequiredArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_case", nullable = false)
    private Long id_case;

    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TestCase testCase = (TestCase) o;
        return id_case != null && Objects.equals(id_case, testCase.id_case);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
