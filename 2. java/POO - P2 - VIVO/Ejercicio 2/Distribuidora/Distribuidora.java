public class Distribuidora {
    public static void main(String[] args){

        //Declaracion de estructura y creacion de los objetos
        Producto[] productos = new Producto[5];

        productos[0] = new Perecedero("Leche", 250, 1);
        productos[1] = new NoPerecedero("Nueces", 85, "Fruto seco");
        productos[2] = new Perecedero("Carne", 1300, 2);
        productos[3] = new NoPerecedero("Atun", 150, "Enlatados");
        productos[4] = new Perecedero("Verduras", 50, 3);

        //Caso de ejemplo producto No Perecedero:
        System.out.println(productos[3]);
        System.out.println("El precio final es de: " + productos[3].calcular(9));
        System.out.println("");

        //Caso de ejemplo producto Perecedero.
        System.out.println(productos[2]);
        System.out.println("El precio final es de: " + productos[2].calcular(9));
        System.out.println("");

    }
}
