package IntegradosClasesAbstracta;

public class ClassOne extends Prototipo {
    public ClassOne(Integer inicio, Integer serie) {
        super(inicio,serie);
    }

    @Override
    public void NextNum() {
        this.setSerie(this.getInicio() + this.getSerie());
    }

    @Override
    public void Reset() {
        this.getInicio();
    }

    @Override
    public void FirstNum(Integer numero) {
        super.setInicio(numero);
    }

    @Override
    public String toString() {
        return "inicio=" + this.getInicio() ;
    }
}
