package com.example.frescos.entity;

import com.example.frescos.enums.ApplicationRol;
import lombok.Data;
import javax.persistence.Entity;
import java.util.List;


@Data
@Entity
public class Buyer extends ApplicationUser {
    public Buyer(Long id, String fullName, List<ApplicationRol> roles) {
        super(id, fullName, roles);
    }

    public Buyer() {
        super();
    }
}
