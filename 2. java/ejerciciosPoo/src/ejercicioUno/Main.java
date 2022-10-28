package ejercicioUno;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Maca", 29, "37518629");
        Persona persona3 = new Persona("Maca", 29, 54, "37518629", 1.54);

        if(persona3.calcularIMC() == -1){
            System.out.println("La persona tiene bajo peso");
        }else if(persona3.calcularIMC() == 1){
            System.out.println("La persona tiene sobre peso");
        }else{
            System.out.println("La persona tiene un peso saludable");
        }

        if(persona3.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }

        System.out.println(persona3.toString());

    }
}


