package ClasesAbsInterfaceDocumentos;

import ClasesAbsInterfaceDocumentos.Class.Curriculums;
import ClasesAbsInterfaceDocumentos.Class.Habilidad;
import ClasesAbsInterfaceDocumentos.Class.PDF;
import ClasesAbsInterfaceDocumentos.Class.Persona;
import ClasesAbsInterfaceDocumentos.Interface.IDocumento;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        IDocumento p = new PDF(12,"Gaston","Titulo","Terror");
        p.imprimirDocumento();

        ArrayList<Habilidad> habilidadArrayList = new ArrayList<>();
        habilidadArrayList.add(new Habilidad("Escribir"));
        IDocumento d2 = new Curriculums(new Persona("Gaston","41288166","Leonardi"),habilidadArrayList);

        System.out.println();
        d2.imprimirDocumento();
    }
}
