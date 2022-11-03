public class Triple extends Prototipo{
    static final int serie = 3;

    public Triple(Integer inicial, Integer valor) {
        super(inicial, valor);
    }
    @Override
    public Integer siguiente(){
        return  (Integer) (this.valor= this.valor.intValue()+serie);
    }

}
