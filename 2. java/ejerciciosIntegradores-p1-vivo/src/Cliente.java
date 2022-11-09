import java.util.List;

public class Cliente {
    private int ID;
    private List<Localizador> localizadorList;

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public Cliente(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadorList.add(localizador);
    }

}
