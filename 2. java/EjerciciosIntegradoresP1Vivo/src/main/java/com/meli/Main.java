package com.meli;

import com.meli.Controllers.ClientController;
import com.meli.Controllers.LocatorController;
import com.meli.Db.Database;
import com.meli.model.Client;
import com.meli.model.Package;
import com.meli.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Conexión a base de datos simulada
        Database database = new Database();

        //Instanciamos productos de la agencia
        Product hotel = new Product(1, "hotel", 1000);
        Product comida = new Product(2, "comida", 1300);
        Product boletos = new Product(3, "boletos", 2000);
        Product transporte = new Product(4, "transporte", 500);

        //Agregamos productos a diferentes paquetes
        List<Product> fullList = new ArrayList<>();
        List<Product> mediumList = new ArrayList<>();
        List<Product> minimalList = new ArrayList<>();
        fullList.add(hotel);
        fullList.add(comida);
        fullList.add(boletos);
        fullList.add(transporte);
        mediumList.add(hotel);
        mediumList.add(hotel);
        mediumList.add(boletos);
        mediumList.add(boletos);
        minimalList.add(comida);
        Package packegeFull = new Package(1, fullList, true);
        Package packegeMedium = new Package(2, mediumList, false);
        Package packegeMinimal = new Package(3, minimalList, false);

        //creación de lista de paquetes que van a ser comprados por juan, en este caso un paquete completo
        List<Package> listPackageJuan = new ArrayList<>();
        listPackageJuan.add(packegeFull);
        //creación de lista de paquetes que van a ser comprados por juan en su segunda compra, en este caso un paquete medio
        List<Package> listPackageJuanTwo = new ArrayList<>();
        listPackageJuanTwo.add(packegeMedium);
        //creación de lista de paquetes que van a ser comprados por juan en su tercera compra, en este caso un paquete minimo
        List<Package> listPackageJuanThree = new ArrayList<>();
        listPackageJuanThree.add(packegeMinimal);

        //Creación de un objeto cliente
        System.out.println("==========================================");
        Client juan = new Client("1020", "Juan");
        //Insertar a Juan en la base de datos
        ClientController clientController = new ClientController(database);
        clientController.post(juan);
        System.out.println("==========================================");
        //Simulación de metodo POST para compra de paquete completo por parte de Juan
        System.out.println("==========================================");
        LocatorController locatorController = new LocatorController(database);
        var response = locatorController.post(listPackageJuan, juan);
        System.out.println("LocatorId:" + response.getId() + "\n" + "Total bruto: " + locatorController.getTotalLocator(response.getId()));
        System.out.println("==========================================");
        System.out.println("==========================================");
        //Simulación para crear un nuevo localizador(compra) por parte de Juan con 2 boletos y 2 hoteles
        var responseTwo = locatorController.post(listPackageJuanTwo, juan);
        System.out.println("LocatorId:" + responseTwo.getId() + "\n" + "Total bruto: " + locatorController.getTotalLocator(responseTwo.getId()));
        System.out.println("==========================================");
        //Simulación para crear un nuevo localizador(compra) con un solo producto y se debe aplciar descuento del 5% por ser cliente fiel
        var responseThree = locatorController.post(listPackageJuanThree, juan);
        System.out.println("LocatorId:" + responseThree.getId() + "\n" + "Total bruto: " + locatorController.getTotalLocator(responseThree.getId()));
        System.out.println("==========================================");
    }
}