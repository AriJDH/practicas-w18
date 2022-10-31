import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Ariel",24,"40974019");
        Persona persona3 = new Persona("Ariel",24,"40974019",104,1.73);

        System.out.println("El IMC es: " + persona3.calcularIMC());
        if (persona3.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }

        if(persona3.calcularIMC() == -1 ){
            System.out.println("Bajo peso");
        }else{
            if (persona3.calcularIMC() == 0){
                System.out.println("Peso saludable");
            }else{
                System.out.println("Sobrepeso");
            }
        }

    }
}