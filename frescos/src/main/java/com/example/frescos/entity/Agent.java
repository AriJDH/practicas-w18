package com.example.frescos.entity;

import javax.persistence.*;

import com.example.frescos.enums.ApplicationRol;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.frescos.enums.ApplicationRol.AGENT;

@Data
@Entity
public class Agent extends ApplicationUser {
    public Agent(Long id, String fullName) {
        super(id, fullName, new ArrayList<>(Arrays.asList(new ApplicationRol[]{AGENT})));
    }

    public Agent(String fullName) {
        super(fullName, new ArrayList<>(Arrays.asList(new ApplicationRol[]{AGENT})));
    }

    public Agent() {
        super();
    }

}
