package com.example.frescos.entity;

import com.example.frescos.enums.ApplicationRol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String password;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<ApplicationRol> roles;

    public ApplicationUser(String userName, String password, List<ApplicationRol> roles) {
        System.out.println(userName);
        this.userName = userName;
        this.password=password;
        this.roles = roles;
    }
}
