package poo_p1;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Pedro", 25, "84654239", 94, 1.94);

        boolean esMayor = persona1.esMayorDeEdad();
        double imc = persona1.calcularMC();

        System.out.println(persona1);
        if(esMayor){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es manor de edad");
        }

        System.out.print(persona1.getNombre() + " ");
        if(imc == -1){
            System.out.println("tiene bajo peso");
        }else if(imc == 0){
            System.out.println("tiene un peso saludable");
        }else{
            System.out.println("tiene sobrepeso");
        }

    }
}
