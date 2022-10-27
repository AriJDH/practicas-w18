import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();
        Persona personaConNombreEdadDni = new Persona("Pepito", 27, "1228473856");
        Persona personaConTodosLosDatos = new Persona("Pepita", 23, "7493658794", 67, 1.65f);

        try {
            FileInputStream file = new FileInputStream("Test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (personaConTodosLosDatos.esMayorDeEdad()) {

        }


    }

}
