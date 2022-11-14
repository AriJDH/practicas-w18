public class Informes implements Impresora{

    private int longitudTexto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informes(int longitudTexto, int cantidadDePaginas, String autor, String revisor){
        this.longitudTexto = longitudTexto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }



    @Override
    public String toString(){
        return "Informe" + "\n" +
                "Longitud de texto: " + this.longitudTexto + "\n" +
                "Cantidad de paginas: " + this.cantidadDePaginas + "\n" +
                "Autor: " + this.autor + "\n" +
                "Revisor: " + this.revisor;
    }

}
