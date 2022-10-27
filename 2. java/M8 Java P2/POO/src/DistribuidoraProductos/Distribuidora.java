package DistribuidoraProductos;

public class Distribuidora {
    public static void main(String[] args) {

        Producto productos[] = new Producto[5];

        productos[0] = new Perecedero("Leche", 10d, 1);
        productos[1] = new Perecedero("Pan", 10d, 2);
        productos[2] = new NoPerecedero("Lenteja", 10d, "Lata");
        productos[3] = new NoPerecedero("Harina", 10d, "Paquete");
        productos[4] = new Perecedero("Crema", 10d, 3);

        for (int i = 0; i < productos.length; i++) {
            if(productos[i] instanceof Perecedero ) {
                System.out.println("Producto Perecedero > Días por caducar: " + ((Perecedero) productos[i]).getDiasPorCaducar());
            } else {
                System.out.println("Producto No Perecedero");
            }
            System.out.println("1 unidad de " + productos[i].getNombre() + " cuesta $" + productos[i].calcular(1));

            System.out.println("2 unidad de " + productos[i].getNombre() + " cuesta $" + productos[i].calcular(2));
            System.out.println(" ---  ");
        }

    }
}
