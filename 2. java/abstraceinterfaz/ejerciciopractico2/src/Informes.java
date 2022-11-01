public class Informes implements Documento{
    private String texto;
    private String cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informes(){}
    public Informes(String texto, String cantidadDePaginas, String autor, String revisor){
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(String cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimirDocumento(String tipoDocumento) {
        System.out.println("Tipo de documento: Informes");
        Informes informes = new Informes();
        System.out.println(informes.toString());
    }
}
