package deporte.entity;


public class Deporte {
    private Integer id =0;
    private String nombre;
    private String nivel;

    public Deporte() {
    }

    public Deporte(Integer id, String nombre, String nivel) {
        this.id +=1;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Deporte(String nombre, String nivel) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
