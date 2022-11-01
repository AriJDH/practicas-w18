package POO_Parte1;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Axel", 17, "3434343");
        Persona persona3 = new Persona("Martin", 28, "43453454", 60, 1.70);

        //Persona persona4 = new Persona("Felix", 34);
        int imc = persona2.calcularIMC();
        boolean mayor = persona2.esMayorDeEdad();

            if(imc == -1) {
            System.out.println("Bajo peso");
        } else if(imc == 0){
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

            if(mayor) {
            System.out.println("Es mayor");
        } else {
            System.out.println("Es menor");
        }
            System.out.println(persona3);
    }
}
