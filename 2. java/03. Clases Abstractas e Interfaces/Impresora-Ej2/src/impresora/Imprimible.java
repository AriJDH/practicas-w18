package impresora;

public interface Imprimible{
    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }
}
