package exercice_2.model;

public class Item {
  private Long code;
  private String name;
  private int quantity;
  private double unitCost;

  public Item() {}

  public void setCode(Long code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setUnitCost(double unitCost) {
    this.unitCost = unitCost;
  }

  public Long getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public double getUnitCost() {
    return unitCost;
  }

  public int getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return (
      "Item { " +
      " Code: " +
      code +
      " Name: " +
      name +
      " Quantity: " +
      quantity +
      "Unit Cost" +
      unitCost +
      "}"
    );
  }
}
