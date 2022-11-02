public class Informe implements Imprimible {
    String texto;
    int longitud;
    int cantPAg;
    String autor;
    String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", longitud=" + longitud +
                ", cantPAg=" + cantPAg +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public Informe(String texto, int longitud, int cantPAg, String autor, String revisor) {
        this.texto = texto;
        this.longitud = longitud;
        this.cantPAg = cantPAg;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantPAg() {
        return cantPAg;
    }

    public void setCantPAg(int cantPAg) {
        this.cantPAg = cantPAg;
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
    public void imprimir(Object  o) {
        System.out.println(o.toString());
    }
}
