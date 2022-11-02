public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos", 60, "339874");
        Persona persona3 = new Persona("Lucas", 40, "3445432", 90, 1.75);

        Persona persona4 = new Persona();

        persona3.toString();

        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

        if(persona3.calcularIMC() == -1){
            System.out.println("Bajo peso");
        }else if(persona3.calcularIMC() == 0){
            System.out.println("Peso saludable");
        }else{
            System.out.println("Sobrepeso");
        }
    }

}
