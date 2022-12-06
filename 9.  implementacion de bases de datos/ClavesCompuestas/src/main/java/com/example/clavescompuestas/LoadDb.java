package com.example.clavescompuestas;

import com.example.clavescompuestas.model.Compra;
import com.example.clavescompuestas.model.CompraKey;
import com.example.clavescompuestas.repository.CompraRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadDb {
    @Autowired
    private CompraRepository compraRepository;
    @PostConstruct
    public void loadDb(){
        CompraKey key1 = new CompraKey(1L, LocalDate.now());
        CompraKey key2 = new CompraKey(2L, LocalDate.now());
        CompraKey key3 = new CompraKey(3L, LocalDate.now());
        CompraKey key4 = new CompraKey(4L, LocalDate.now());
        CompraKey key5 = new CompraKey(5L, LocalDate.now());

        Compra compra1 = new Compra(key1, 1000.0, "Compra 1");
        Compra compra2 = new Compra(key2, 2000.0, "Compra 2");
        Compra compra3 = new Compra(key3, 3000.0, "Compra 3");
        Compra compra4 = new Compra(key4, 4000.0, "Compra 4");
        Compra compra5 = new Compra(key5, 5000.0, "Compra 5");

        compraRepository.save(compra1);
        compraRepository.save(compra2);
        compraRepository.save(compra3);
        compraRepository.save(compra4);
        compraRepository.save(compra5);

        compraRepository.findById(key1).ifPresent(c -> System.out.println(c.getDescripcion()));

    }
}
