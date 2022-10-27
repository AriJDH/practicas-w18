import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String nombre, dni;
        int edad;
        double peso,altura;
        System.out.println("Se agregara una persona solo con nombre, edad y dni");
        System.out.println("Ingresa nombre");
        nombre = in.nextLine();
        System.out.println("Ingresa edad");
        edad = (Integer.parseInt(in.nextLine()));
        System.out.println("Ingresa dni");
        dni = in.nextLine();
        Persona agregarPersonaNEDNI = new Persona(nombre,edad,dni);
        System.out.println("Se agregara una persona, se requiere la siugiente informacion: nombre, edad, dni, peso y altura");
        System.out.println("Ingresa nombre");
        nombre = in.nextLine();
        System.out.println("Ingresa edad");
        edad = (Integer.parseInt(in.nextLine()));
        System.out.println("Ingresa dni");
        dni = in.nextLine();
        System.out.println("Ingresa peso");
        peso = in.nextDouble();
        System.out.println("Ingresa altura");
        altura = in.nextDouble();
        Persona agregarPersonaNEDNIPA = new Persona(nombre, edad, dni, peso, altura);
        /* No es posible construir un objeto de tipo persona pansadole el el atributo nombre ya que no existe un constructor que reciba el parametro nombre por si solo.
         * Tampoco es posible contruir un objeto de tipo persona pasandole como argumento el atributo edad ya que no existe un constructor que reciba solo el atributo edad*/
        System.out.println("La ultima informacion registrada es: ");
        System.out.println();
        System.out.println(agregarPersonaNEDNIPA);
        System.out.println("Nivel de peso: " + calcularNivelDePeso(agregarPersonaNEDNIPA.calcularIMC()));
        System.out.print("La persona registada es ");
        if(agregarPersonaNEDNIPA.esMayorDeEdad() == true){
            System.out.print("mayor");
        }else {
            System.out.print("menor");
        }
    }

    private static String calcularNivelDePeso(int numIMC) {
        if (numIMC == -1) {
            return "Bajo peso";
        } else if (numIMC == 0) {
            return "Peso saludable";
        } else {
            return "Sobrepeso";
        }
    }
}
