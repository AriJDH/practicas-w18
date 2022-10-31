package imprimir;

public class Informes implements Imprimir{
    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;
    private String texto;

    public Informes(Integer cantidadDePaginas, String autor, String revisor, String texto) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
