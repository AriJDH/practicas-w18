public class Informes implements Imprimible{
    String texto, autor, revisor;
    int cantPaginas;

    public Informes(String texto, String autor, String revisor, int cantPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.cantPaginas = cantPaginas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "informes{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantPaginas=" + cantPaginas +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el informe de "+this.autor);
    }
}
