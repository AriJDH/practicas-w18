package ejercicio2;

public class Distribuidora {

    public static void main(String[] args) {

        Producto productos[] = new Producto[5];

        productos[0] = new Perecedero("Leche",1000,3);
        productos[1] = new Perecedero("Pan",2000,10);
        productos[2] = new NoPerecedero("Arvejas", 5000, "Enlatado" );
        productos[3] =  new NoPerecedero("Maiz", 4000, "Enlatado" );
        productos[4] = new Perecedero("Tomate",400,1);

        for(Producto p:productos){
            System.out.println("5 unidades de " + p.getNombre() + " cuestan $" + p.calcular(5));
        }
    }
}
