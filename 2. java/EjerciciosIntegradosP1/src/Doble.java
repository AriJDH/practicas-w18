public class Doble extends Prototipo {

    static final int serie = 2;


    public Doble(Integer inicial, Integer valor) {
        super(inicial, valor);
    }
    @Override
    public Integer siguiente(){
        return (Integer) (this.valor= this.valor.intValue()+serie);
    }

}
