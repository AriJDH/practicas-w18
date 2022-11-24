import java.util.List;

// El prototipo va a usar el Generic <T>
public abstract class Prototipo<T> {

    // Atributos de tipo T
    protected T initialValue; // Valor inicial de la serie
    protected T value; // Valor actual, último valor seteado
    protected T a; // Valor que se agrega

    // Constructores
    public Prototipo() {
    }

    public Prototipo(T initialValue, T value, T a) {
        this.initialValue = initialValue;
        this.value = value;
        this.a = a;
    }

    // Getters

    public T getInitialValue() {
        return initialValue;
    }

    public T getValue() {
        return value;
    }

    public T getA() {
        return a;
    }


    // --------- Métodos --------- //

    /* Devuelve un valor siguiente */
    public abstract T nextValue(T a);

    /* Reinicia la serie */
    public abstract void setValue();

    /* Establece valor inicial */
    public abstract void setInitialValue(T newInitialValue);

    /* Establecer valor que se suma en cada iteración */
    public abstract void setA(T newA);
}