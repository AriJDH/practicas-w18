package com.example.frescos.entity;

import lombok.Data;
import javax.persistence.Entity;
import java.util.List;


@Data
@Entity
public class Buyer extends User{
    public Buyer(Long id, String fullName, List<Integer> roles) {
        super(id, fullName, roles);
    }

    public Buyer() {
        super();
    }
}
