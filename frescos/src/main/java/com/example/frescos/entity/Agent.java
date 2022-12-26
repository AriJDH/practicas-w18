package com.example.frescos.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
public class Agent extends ApplicationUser {
    public Agent(Long id, String fullName, List<Integer> roles) {
        super(id, fullName, roles);
    }

    public Agent() {
        super();
    }
}
