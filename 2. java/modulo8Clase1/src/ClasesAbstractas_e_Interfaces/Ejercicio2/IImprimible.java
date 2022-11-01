package ClasesAbstractas_e_Interfaces.Ejercicio2;

import ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos.Documento;

public interface IImprimible {
     static void imprimir (Documento d){
         System.out.println(d.toString());
    }
}
