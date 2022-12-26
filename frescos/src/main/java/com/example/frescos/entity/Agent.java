package com.example.frescos.entity;

import javax.persistence.*;

import com.example.frescos.enums.ApplicationRol;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Agent extends ApplicationUser {
    public Agent(Long id, String fullName, List<ApplicationRol> roles) {
        super(id, fullName, roles);
    }

    public Agent() {
        super();
    }

}
