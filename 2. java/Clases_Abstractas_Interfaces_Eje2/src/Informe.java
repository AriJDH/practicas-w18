public class Informe implements Imprimible{

    private int cant_Pags;
    private String autor;
    private  String revisor;
    private String texto;

    public Informe(int cant_Pags, String autor, String revisor, String texto) {
        this.cant_Pags = cant_Pags;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "cant_Pags=" + cant_Pags +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
