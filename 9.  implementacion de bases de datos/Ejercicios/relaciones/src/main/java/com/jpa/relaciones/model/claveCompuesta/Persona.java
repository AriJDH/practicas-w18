package com.jpa.relaciones.model.claveCompuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "personas")
@IdClass(value = PersonaKey.class) //Para indicar que tendremos una clave compuesta con la clase que pasamos por parámetro
@Getter @Setter
public class Persona {

    //En las claves compuestas, cada atributo tiene que tener su annotations @Id
    @Id
    private Integer dni;
    @Id
    private Integer numTramite;

}
