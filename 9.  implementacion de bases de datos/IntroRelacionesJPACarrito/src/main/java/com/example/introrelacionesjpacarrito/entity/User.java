package com.example.introrelacionesjpacarrito.entity;

import org.hibernate.engine.internal.Cascade;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
