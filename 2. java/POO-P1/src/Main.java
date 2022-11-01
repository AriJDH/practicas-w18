public class Main {
    //Ejercicio 3
    public static void main(String[] args) {

        //Ejercicio 4
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jose Martinez", 23,"42000000");
        Persona persona3 = new Persona("Sofia Fernandez", 30,"36000000", 57.3, 1.64);

        /*
        * Crear un objeto de tipo Persona pasando solo el nombre y edad no es posible ya que no definimos un
        * constructor que reciba solo estos dos parametos -> esto nos marcara un error ya que no es posible.
        * */
        //Persona persona4= new Persona("Maria Perez",40);

        //Ejercicio 6
        System.out.println("Datos de persona: ");
        System.out.println(persona3.toString());
        System.out.println("Calculo de IMC: "+persona3.calcularIMC());
        System.out.println("¿Es mayor de edad? "+persona3.esMayorDeEdad());
    }
}