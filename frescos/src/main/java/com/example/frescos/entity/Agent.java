package com.example.frescos.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class Agent extends User{
    public Agent(Long id, String fullName, List<Integer> roles) {
        super(id, fullName, roles);
    }

    public Agent() {
        super();
    }
}
