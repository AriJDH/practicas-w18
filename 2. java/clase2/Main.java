package clase2;

public class Main {

    public static void main(String[] args) {


        Persona p1 = new Persona("Juan", 20, "12345678");
        Persona p2 = new Persona("Pedro", 30, "87654321", 80, 1.80f);
        Persona p3 = new Persona();

        //Persona p4 = new Persona("Maria", 40);


        float imc = p2.calcularIMC();
        System.out.println("imc: "+imc);
        boolean mayor = p2.esMayorDeEdad();
        if (mayor)
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");


        if(imc == -1)
            System.out.println("Bajo peso");
        else if(imc == 0)
            System.out.println("Peso normal");
        else
            System.out.println("Sobrepeso");

    }
}
