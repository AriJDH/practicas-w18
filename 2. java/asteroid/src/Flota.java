import java.util.ArrayList;
import java.util.List;

public class Flota implements Componente{
    /** Esta es la clase composite, almacena componenete hijo **/

    private List<Componente> naves = new ArrayList<>();


    public List<Componente> getNaves() {
        return naves;
    }

    public void setNaves(List<Componente> naves) {
        this.naves = naves;
    }

    @Override
    public double getDistancia() {
        double total = 0;

        for(Componente nave : naves){
            //total += Math.sqrt(Math.pow(nave.getX()- 2*(nave.getX()), 2) + Math.pow(nave.getY()- 2*(nave.getY()), 2));
            total += nave.getDistancia();
        }

        return total/naves.size();
    }

    @Override
    public void add(Componente e) {
        naves.add(e);
    }

    @Override
    public void delete(Componente e) {
        naves.remove(e);
    }
}
