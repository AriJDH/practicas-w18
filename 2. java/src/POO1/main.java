package POO1;

public class main {
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Gaston",12,"41288166");
        Persona persona3 = new Persona("Agustin",23,"41233444",83,1.78);

        System.out.printf("El IMC de %s es %s \n", persona3.getNombre(),persona3.calcularIMC());
        System.out.printf("%s es mayor de Edad? %b \n", persona3.getNombre(),persona3.esMayorEdad());
        System.out.printf(persona3.toString());
    }
}
