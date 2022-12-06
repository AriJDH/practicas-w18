package example.ejemplo1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

//Mapeos JPA
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private String name;
    private  String lastname;


}
