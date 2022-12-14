package Model;

public class Item {

    private String codigo;
    private int cantComprada;
    private int costoUnitario;

    public Item(){

    }

    public Item(String codigo, int cantComprada, int costoUnitario){
        this.codigo = codigo;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public int getCostoUnitario() {
        return costoUnitario;
    }
}
