package SaveTheRopa.Clases;

public class Main {
    public static void main(String[] args) {
            ArmaPrendas prenda = new ArmaPrendas("Adidas", "2022");
            ArmaPrendas prenda2 = new ArmaPrendas("Nike", "2022");

            GuardaRopa guardaRopa = new GuardaRopa();
            guardaRopa.guardarPrendas(prenda.getPrendas());
            guardaRopa.guardarPrendas(prenda2.getPrendas());

            guardaRopa.mostrarPrenda();
            System.out.println(guardaRopa.devolverPrendas(1));
    }
}
