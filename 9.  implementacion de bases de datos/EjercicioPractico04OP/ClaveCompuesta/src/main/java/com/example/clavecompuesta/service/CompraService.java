package com.example.clavecompuesta.service;

import com.example.clavecompuesta.entity.CompraEntity;
import com.example.clavecompuesta.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public void createCompra() {

        CompraEntity compra1 = new CompraEntity();
        compra1.setClientId(1);
        LocalDate date1 = LocalDate.parse("20/12/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        compra1.setFecha(date1);
        compra1.setArticulo("Atun");
        compra1.setCantidad(3);
        compraRepository.save(compra1);

        CompraEntity compra2 = new CompraEntity();
        compra2.setClientId(2);
        LocalDate date2 = LocalDate.parse("07/04/2012", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        compra2.setFecha(date2);
        compra2.setArticulo("Curitas");
        compra2.setCantidad(30);
        compraRepository.save(compra2);

        CompraEntity compra3 = new CompraEntity();
        compra3.setClientId(3);
        LocalDate date3 = LocalDate.parse("15/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        compra3.setFecha(date3);
        compra3.setArticulo("Magistral");
        compra3.setCantidad(6);
        compraRepository.save(compra3);

        CompraEntity compra4 = new CompraEntity();
        compra4.setClientId(4);
        LocalDate date4 = LocalDate.parse("22/05/2009", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        compra4.setFecha(date4);
        compra4.setArticulo("Trapo de piso");
        compra4.setCantidad(2);
        compraRepository.save(compra4);

        CompraEntity compra5 = new CompraEntity();
        compra5.setClientId(5);
        LocalDate date5 = LocalDate.parse("03/03/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        compra5.setFecha(date5);
        compra5.setArticulo("Jabon");
        compra5.setCantidad(20);
        compraRepository.save(compra5);

    }

}
