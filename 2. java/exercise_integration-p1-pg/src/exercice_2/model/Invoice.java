package exercice_2.model;

import java.util.List;

public class Invoice {
  private Long id;
  private Client client;
  private List<Item> itemList;
  private double total;

  public Client getClient() {
    return client;
  }

  public Long getId() {
    return id;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public double getTotal() {
    return total;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  @Override
  public String toString() {
    return (
      "Invoice { " +
      " Code: " +
      id +
      " Client: " +
      client.toString() +
      " Item List: " +
      itemList +
      "Total" +
      total +
      "}"
    );
  }
}
