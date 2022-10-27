package POO1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Marcos", 29, "979837459");
        Persona persona3 = new Persona("carlos", 34, "393899393", 85f, 1.7f);
        //Persona persona4 = new Persona("Carlos", "40"); //no es posible por que no tenemos este tipo de constructor

        System.out.println(persona3);
        if(persona3.cacularIMC() < 0){
            System.out.println("Esta bajo de peso");
        }else if(persona3.cacularIMC() == 0){
            System.out.println("Tiene peso saludable");
        }else{
            System.out.println("Tiene sobre peso");
        }

        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("No es mayor de edad");
        }

    }
}
