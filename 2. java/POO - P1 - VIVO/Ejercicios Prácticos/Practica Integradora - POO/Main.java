public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona();
        Persona p2 = new Persona("Pedro", 32, "32.222.321");
        Persona p3 = new Persona("Juan", 28, "39.201.887", 85.6, 1.91);

        // Persona p4 = new Persona("Jose", 31); Esto no es posible ya que el constructor debe recibir todos sus parametros obligatoriamente.

        //Calculo del IMC
        System.out.println(p3);
        if(p3.calcularIMC() == -1) {
            System.out.println("IMC Por debajo de 20 -> Peso bajo");
        } else if(p3.calcularIMC() == 0) {
            System.out.println("IMC entre 20 y 25 inclusive -> Peso saludable");
        } else {
            System.out.println("IMC Mayor de 25 -> Sobrepeso");
        }

    }
}