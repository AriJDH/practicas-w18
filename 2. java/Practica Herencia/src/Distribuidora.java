public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];

        Producto leche = new Perecedero("Leche",20,2);
        Producto mayonesa = new Perecedero("Mayonesa",30,1);
        Producto ketchup = new Perecedero("Ketchup",50,3);
        Producto carne = new Perecedero("Carne",100,1);
        Producto cebolla = new Perecedero("Cebolla",5000,1);

        Producto fideo = new NoPerecedero("Fideo", 10, "tipo");
        Producto arroz = new NoPerecedero("Arroz", 20, "tipo");
        Producto plastico = new NoPerecedero("Plastico", 30, "tipo");
        Producto java = new NoPerecedero("Java", 500, "tipo");
        Producto ide = new NoPerecedero("Ide", 350, "tipo");

        productos[0] = leche;
        productos[1] = mayonesa;
        productos[2] = ketchup;
        productos[3] = carne;
        productos[4] = cebolla;
        productos[5] = fideo;
        productos[6] = arroz;
        productos[7] = plastico;
        productos[8] = java;
        productos[9] = ide;

        for (int i = 0; i < productos.length; i++){
            System.out.println( productos[i].getNombre() + " tiene un costo de : " +productos[i].calcular(3));
        }




    }
}
