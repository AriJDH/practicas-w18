package Excepciones2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        NoPerecedero productoUno = new NoPerecedero("Escoba", 70.00, "limpieza");
        productos.add(productoUno);

        NoPerecedero productoDos = new NoPerecedero("perfume", 500.00, "perfumería");
        productos.add(productoDos);

        Producto productoTres = new Producto("plato", 30.00);
        productos.add(productoTres);

        Perecedero productoCuatro = new Perecedero("Yogur", 250.00, 2);
        productos.add(productoCuatro);

        double montoFactura = 0.00;

        for (int i = 0; i < productos.size(); i++) {

            montoFactura += productos.get(i).calcular(i + 1);

        }
        System.out.println("El total de la factura es..: $ " + montoFactura );
    }
}
