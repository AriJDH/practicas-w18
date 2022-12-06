package meli.bootcamp.miniseries.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "series_id")
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amountAwards;
}
