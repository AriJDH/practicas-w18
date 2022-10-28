import logica.Persona;

public class Main {

    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona personaConNombreApellidoDni = new Persona("Felipe", 13, "Ad34p9");
        Persona personaConTodosParametros = new Persona("Sanda",33,"Asd34", 60, 1.70);

        switch (personaConTodosParametros.calcularIMC()){
            case -1:
                System.out.print(personaConTodosParametros.getNombre() + " esta baja de peso");
                break;
            case 0:
                System.out.print(personaConTodosParametros.getNombre() + " esta saludable");
                break;
            case 1:
                System.out.print(personaConTodosParametros.getNombre() + " tiene sobrepeso");
        }

        if (personaConTodosParametros.esMayorDeEdad()){
            System.out.println(" y es mayor de edad");
        } else {
            System.out.println(" y es menor de edad");
        }
    }
}
