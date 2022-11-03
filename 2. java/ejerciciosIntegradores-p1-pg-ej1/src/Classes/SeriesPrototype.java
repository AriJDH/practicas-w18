package Classes;

public abstract class SeriesPrototype <T extends Number> { //make T numeric
     T type;
     T initialValue;
     T currentValue;

     public SeriesPrototype(T type, T initialValue) {
          this.type = type;
          setInitialValue(initialValue);
          restartSeries();
     }

     public abstract T nextValue();
     public abstract void restartSeries();
     public abstract void setInitialValue(T initialValue);
}
