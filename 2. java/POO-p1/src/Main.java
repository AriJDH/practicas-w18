/*Ejercicio 3
Creá una clase nueva llamada Main, donde declares un método main como te enseñamos anteriormente.
Esto nos permitirá ejecutar nuestra aplicación.*/
public class Main {
    public static void main(String[] args) {
        /*Ejercicio 4
En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees un objeto de tipo Persona
por cada constructor que hayamos definido en la clase, recuerda poner un nombre significativo a las variables donde
vas a asignar cada objeto. ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona y vamos a
construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor. ¿Es esto posible?
¿Qué sucede si tratamos de hacer esto? RTA: el objeto no puede construirse.
*/
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Agus", 31, "35767298", 67.0, 1.65);
        Persona persona3 = new Persona("Aldy", 30, "", 0.0, 0.0);

        /*Ejercicio 6
Desde la clase Main vamos a calcular el IMC de la última persona que creamos (la que creamos correctamente mediante
el constructor que recibe todos los atributos como parámetro). También vamos a averiguar si es mayor de edad o no;
ten en cuenta que en ambos casos, dependiendo de los resultados retornados por los métodos, debes imprimir un
mensaje acorde para el usuario. Finalmente queremos mostrar todos los datos de esa persona imprimiendo dicha
información por consola. El formato en que vas a mostrar los datos y los mensajes quedan a tu criterio, pero
debe ser legible y descriptivo para quien ve la salida del programa.
Referencias:

Índice de masa corporal (IMC)
Nivel de peso
Por debajo de 20- Bajo peso
Entre 20 y 25 inclusive- Peso saludable
Mayor de 25- Sobrepeso
         */
        System.out.println(persona2.toString());
        persona2.calcularIMC();
        String msjIMC = "";
        if (persona2.calcularIMC() == -1) {
            msjIMC = "Bajo Peso";
        } else if (persona2.calcularIMC() == 0) {
            msjIMC = "Peso Saludable";
        } else if (persona2.calcularIMC() == 1) {
            msjIMC = "Sobrepeso";
        }
        System.out.println("El IMC del sujeto es: " + msjIMC);

        String msjEdad = "";
        if (persona2.esMayorDeEdad() == true) {
            msjEdad = "Es mayor de edad";
        } else if (persona2.esMayorDeEdad() == false) {
            msjEdad = "No es mayor de edad";
        }
        System.out.println(msjEdad);
    }
}
