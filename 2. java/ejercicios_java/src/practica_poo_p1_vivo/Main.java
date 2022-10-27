package practica_poo_p1_vivo;

public class Main {
    public static void main(String[] args) {

        Jaguar jaguar = new Jaguar();

        jaguar.setNombre("Jaguar 1");
        jaguar.setEdad("10");
        jaguar.setSexo("macho");
        jaguar.setLugarNacimiento("amazonas");
        System.out.println(jaguar.toString());

        Jaguar jaguar2 = new Jaguar("Michi", "23");

    }
}
