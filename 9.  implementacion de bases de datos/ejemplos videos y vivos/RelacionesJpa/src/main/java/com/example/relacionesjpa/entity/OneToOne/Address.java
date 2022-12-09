package com.example.relacionesjpa.entity.OneToOne;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
