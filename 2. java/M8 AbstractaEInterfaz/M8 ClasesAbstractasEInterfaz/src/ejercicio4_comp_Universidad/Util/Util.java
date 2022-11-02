package ejercicio4_comp_Universidad.Util;

import ejercicio4_comp_Universidad.Intefaz.FuncionDocencia;
import ejercicio4_comp_Universidad.Intefaz.FuncionSoporteTecnico;
import ejercicio4_comp_Universidad.Model.*;

import java.util.Arrays;

public class Util {
    public static Persona[] cargarPersonal(Persona... personal){

        for (Persona p: personal) {
            Arrays.stream(personal).toArray();
        }
        return personal;
    }

    public static void mostrarPersonal(Persona[] personal) {
        for (Persona p: personal) {
            System.out.println(p);
            if(p instanceof Tecnico || p instanceof SoporteTecnico){
                ((FuncionSoporteTecnico) p).darSoporteTecnico();
            }

            if(p instanceof Tutor || p instanceof Docente){
                ((FuncionDocencia) p).darTutoria();
            }
            System.out.println( " ---- ");
        }
    }
}
