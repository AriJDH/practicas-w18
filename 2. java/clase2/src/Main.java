import poo1.Jaguar;

public class Main {
    public static void main(String[] args) {
        Jaguar jaguar = new Jaguar();
        jaguar.setEdad(10);
        jaguar.setPeso(80);

        Jaguar jaguar2 = new Jaguar(20, 55);
        System.out.println(jaguar);
        System.out.println(jaguar2);

    }
}