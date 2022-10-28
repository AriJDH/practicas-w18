
//TRABAJO HECHO EN GRUPO

public class Main {
    public static void main(String[] args) {

//        Perecedero pere1 = new Perecedero("leche", 10, 2);
//        Perecedero pere2 = new Perecedero("yogurt", 20, 3);
//        Perecedero pere3 = new Perecedero("pollo", 30, 7);
        NoPerecedero npere1 = new NoPerecedero("chicle", 2, "golosina");
//        NoPerecedero npere2 = new NoPerecedero("alfajor", 8, "golosina");

        Distribuidora distribuidora = new Distribuidora();

//        distribuidora.agregarProducto(pere1);
//        distribuidora.agregarProducto(pere2);
//        distribuidora.agregarProducto(pere3);
        distribuidora.agregarProducto(npere1);
//        distribuidora.agregarProducto(npere2);

        System.out.println(        distribuidora.calcularTotalVenta());

    }
}