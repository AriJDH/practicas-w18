package com.meli;

public class Distribuidora {
    public static void main(String[] args) {

        Producto[] productos = new Producto[]{new Perecedero("leche", 3000, 2), new NoPerecedero("arroz", 5000), new Perecedero("huevo", 500, 5), new Perecedero("carne", 18000, 6), new NoPerecedero("atún", 4500)};

        for (var producto : productos) {
            System.out.println("---------------------------------------");
            System.out.println("Producto:" + producto.getNombre());
            System.out.println("Precio unitario: " + producto.getPrecio());
            if(producto.getClass() == Perecedero.class){
                var pereceder = (Perecedero) producto;
                System.out.println("Caducidad: " + pereceder.getDiasPorCaducidad() + " días." );
            }
            System.out.println("Total de ventas por 5 unidades (Con deducciones por caducidad si aplica):" + producto.calcular(5));
            System.out.println("---------------------------------------");
        }

    }
}