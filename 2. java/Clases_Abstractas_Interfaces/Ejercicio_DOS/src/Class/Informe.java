package Class;

import Interface.Imprimible;

public class Informe implements Imprimible {

    private Integer longitud;
    private Integer cantHojas;
    private String autor;
    private String revisor;

    public Informe(Integer longitud, Integer cantHojas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantHojas = cantHojas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getCantHojas() {
        return cantHojas;
    }

    public void setCantHojas(Integer cantHojas) {
        this.cantHojas = cantHojas;
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
    public String toString() {
        return "Informe{" +
                "longitud=" + longitud +
                ", cantHojas=" + cantHojas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public void imprimir(){
        System.out.println(this.toString());
    }


}
