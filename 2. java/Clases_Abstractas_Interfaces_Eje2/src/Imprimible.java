public interface Imprimible<T> {

    static <T> void imprimir( T documento) {
        System.out.println(documento.toString());
    }

}
