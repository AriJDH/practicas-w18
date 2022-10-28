package clase2.EjPractivoVivo2;

public class Main {
    public static void main(String[] args) {
        Perecedero pere = new Perecedero("fideos",100,2);
        System.out.println("El precio final es: $" + pere.calcular(3));
    }
}
