package exercice_2.model;

public class Client {
  private Long DNI;
  private String name;
  private String lastName;

  public Client(Long DNI, String name, String lastName) {
    this.DNI = DNI;
    this.name = name;
    this.lastName = lastName;
  }

  public Long getDNI() {
    return DNI;
  }

  public String getLastName() {
    return lastName;
  }

  public String getName() {
    return name;
  }

  public void setDNI(Long dNI) {
    DNI = dNI;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return (
      "Client { " +
      " DNI: " +
      DNI +
      " Name: " +
      name +
      " Last name: " +
      lastName +
      "}"
    );
  }
}
