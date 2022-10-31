package InterfacesYClaseAbstractas.documentos.interfaces;

import InterfacesYClaseAbstractas.documentos.clases.Documento;

public interface Imprimible {
    static void print(Documento documento){
        documento.imprimir();
    }
};
