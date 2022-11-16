package InterfacesYClaseAbstractas.serierNumericas;

public class Secuencia extends Prototipo{

    private Number comienzoSecuencia;
    private Number numeroActual;

    public Number getComienzoSecuencia() {
        return comienzoSecuencia;
    }

    public void setComienzoSecuencia(Number comienzoSecuencia) {
        this.comienzoSecuencia = comienzoSecuencia;
    }

    public Number getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(Number numeroActual) {
        this.numeroActual = numeroActual;
    }

    @Override
    Number retornarNumero() {
        /*if (getNumeroActual() instanceof Integer) {
            Number numero = (int) getNumeroActual() + 2;
            setNumeroActual(numero);
        }

        if (getNumeroActual() instanceof Double) {
            Number numero = (double) getNumeroActual() + 2;
            setNumeroActual(numero);
        }*/

        var numero = getNumeroActual();
        return getNumeroActual();
    }

    @Override
    Number iniciarSecuencia(Number numero) {
        setComienzoSecuencia(numero);
        setNumeroActual(getComienzoSecuencia());
        return getComienzoSecuencia();
    }

    @Override
    Number setearSecuencia() {
        setNumeroActual(getComienzoSecuencia());
        return getNumeroActual();
    }


}
