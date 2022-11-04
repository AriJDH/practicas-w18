import java.util.List;

public class Localizador {

    // Atributos
    private Long id;
    private Cliente cliente;
    private List<Reservable> reservables;
    private Double precioTotal;

    // Constructores
    public Localizador() {
    }

    public Localizador(Long id, Cliente cliente, List<Reservable> reservables, Double precioTotal) {
        this.id = id;
        this.cliente = cliente;
        this.reservables = reservables;
        this.precioTotal = precioTotal;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reservable> getReservables() {
        return reservables;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    // Métodos
    public void agregarReservable(Reservable reservable) {
        this.reservables.add(reservable);
    }
}
