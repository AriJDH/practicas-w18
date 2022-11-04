import java.util.ArrayList;

public class Repositorio {
    private ArrayList<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public void agregaLocalizador(Localizador localizador){

        this.localizadores.add(localizador);
    }

    public void showLocalizadores(){
        for (Localizador localizador: localizadores
             ) {
            System.out.println(localizador);
        }
    }

}
