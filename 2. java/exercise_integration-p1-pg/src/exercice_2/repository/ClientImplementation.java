package exercice_2.repository;

import exercice_2.model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImplementation implements CRUDRepository<Client> {
  public List<Client> clientList = new ArrayList<Client>();

  @Override
  public void save(Client object) {
    clientList.add(object);
  }

  @Override
  public Optional<Client> find(Long id) {
    boolean state = false;
    for (Client client : clientList) {
      if (client.getDNI().equals(id)) {
        System.out.println(":: Client was found ::");
        System.out.println(
          "DNI: " +
          client.getDNI() +
          " Name: " +
          client.getName() +
          " Lastname: " +
          client.getLastName()
        );

        return Optional.of(client);
      }
    }

    if (state == false) {
      System.out.println("Client doesn't was found");
    }

    return Optional.empty();
  }

  @Override
  public List<Client> listAll(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(Long id) {
    Optional<Client> client = this.find(id);

    if (client.isEmpty()) {
      System.out.println("Client not found");
    } else {
      System.out.println(
        "Client with " + client.get().getDNI() + " Was deleted "
      );
      clientList.remove(client.get());
    }
  }

  @Override
  public void show() {
    for (Client client : this.clientList) {
      System.out.println(
        "DNI: " +
        client.getDNI() +
        " Name: " +
        client.getName() +
        " Lastname: " +
        client.getLastName()
      );
    }
  }
}
