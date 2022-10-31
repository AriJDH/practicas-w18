package example;

public class Perro extends Animal {
  String nombre;

  public Perro(String especie, String nombre) {
    super(especie);
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public void mostrarEspecie() {
    super.mostrarEspecie();
    System.out.println("Soy un perro que ladra");
  }


  @Override
  public void hacerSonido() {
    System.out.println("Guau");
  }
}
