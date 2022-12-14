public class Item {

    private Long codigo;
    private String cantComprada;
    private String costoUnitario;

    public Item(){

    }

    public Item(Long codigo, String cantComprada, String costoUnitario){
        this.codigo = codigo;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCantComprada(String cantComprada) {
        this.cantComprada = cantComprada;
    }

    public void setCostoUnitario(String costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getCantComprada() {
        return cantComprada;
    }

    public String getCostoUnitario() {
        return costoUnitario;
    }
}
