package clase3_b_EjerComplementarios.Ej2;

public class Test {
    public static void main(String[] args) {
        Flota flota1 = new Flota();
        Nave nave0 = new Nave("Nave0", 2, 2);

        flota1.addNave(new Nave("Nave1", 1, 3));
        flota1.addNave(new Nave("Nave2", 2, 6));
        System.out.println(flota1.toString());
        System.out.println(flota1.getDistancia(6,6));
        System.out.println(nave0.getDistancia(6,6));

    }

}
