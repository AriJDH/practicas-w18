package com.example.frescos.entity;

import com.example.frescos.enums.ApplicationRol;
import lombok.Data;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.frescos.enums.ApplicationRol.AGENT;
import static com.example.frescos.enums.ApplicationRol.BUYER;


@Data
@Entity
public class Buyer extends ApplicationUser {
    public Buyer(Long id, String fullName) {
        super(id, fullName, new ArrayList<>(Arrays.asList(new ApplicationRol[]{BUYER})));
    }

    public Buyer( String fullName) {
        super(fullName, new ArrayList<>(Arrays.asList(new ApplicationRol[]{BUYER})));
    }

    public Buyer() {
        super();
    }
}
