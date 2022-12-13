package com.example.introrelacionesjpacarrito.entity;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String address;

    @OneToOne(mappedBy = "address")
    private User user;
}
