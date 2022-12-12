package com.jpa.clavesCompuestas;

import com.jpa.clavesCompuestas.model.Compra;
import com.jpa.clavesCompuestas.model.CompraKey;
import com.jpa.clavesCompuestas.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class dataLoad {

    @Autowired
    private CompraRepository compraRepository;


    //@PostConstruct
    /*
    * Esta annotation define un método como método de inicialización de un bean
    * de resorte que se ejecuta después de que se complete la inyección de dependencia.
    * @PostConstruct es la forma de anotación de init-method que es un atributo de la etiqueta bean.
    * Se utiliza para validar las propiedades de bean o para inicializar cualquier tarea.
    * En nuestro bean debe haber sólo un método anotado con @PostConstruct y no puede ser estático.
    * */

    @PostConstruct
    public void loadDataTest(){

        CompraKey key1 = new CompraKey(1, LocalDate.now());
        CompraKey key2 = new CompraKey(1, LocalDate.now().plusWeeks(1));
        CompraKey key3 = new CompraKey(1, LocalDate.now().plusDays(3));
        CompraKey key4 = new CompraKey(1, LocalDate.now().plusMonths(1));
        CompraKey key5 = new CompraKey(1, LocalDate.now().plusYears(1));

        Compra c1 = new Compra(key1, 100, "Caramelos");
        Compra c2 = new Compra(key2, 200, "Chupetines");
        Compra c3 = new Compra(key3, 300, "Chocolates");
        Compra c4 = new Compra(key4, 400, "Jugo");
        Compra c5 = new Compra(key5, 500, "Yerba");


        compraRepository.save(c1);
        compraRepository.save(c2);
        compraRepository.save(c3);
        compraRepository.save(c4);
        compraRepository.save(c5);


    }
}
