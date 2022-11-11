package IntegradosClasesAbstracta;

public abstract class Prototipo {
    private Integer inicio;
    private Integer serie;
    private Integer sum;


    public Prototipo(Integer inicio, Integer serie) {
        this.inicio = inicio;
        this.serie = serie;
        this.sum = inicio;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public abstract void NextNum();
    public abstract void Reset();
    public abstract void FirstNum(Integer numero);
}
