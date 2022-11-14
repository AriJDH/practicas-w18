public interface Impresora {

    static void imprimir(Object documento){
        System.out.println("Usted esta imprimiendo el siguiente documento: " + "\n" + documento);
    };

}
