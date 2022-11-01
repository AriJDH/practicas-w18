public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[5];

        Producto cafe = new NoPerecedero("cafe",25520,"grano");
        Producto arroz = new NoPerecedero("Arroz",60000,"cereal");
        Producto manzanas = new Perecedero("Manzana",1200,2);
        Producto carne = new Perecedero("Carne",13000,1);
        Producto atun = new NoPerecedero("Atun",7000,"conservantes");

        productos[0] = cafe;
        productos[1] = arroz;
        productos[2] = manzanas;
        productos[3] = carne;
        productos[4] = atun;

        for (Producto producto:productos){
            System.out.println("Total al vender 5 productos de "+ producto.getNombre() +
                    " es de " + producto.calcular(5) );
        }


    }

}
