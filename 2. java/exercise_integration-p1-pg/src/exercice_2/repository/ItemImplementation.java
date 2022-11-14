package exercice_2.repository;

import exercice_2.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImplementation implements CRUDRepository<Item> {
  public List<Item> itemList = new ArrayList<Item>();

  @Override
  public void save(Item object) {
    // TODO Auto-generated method stub
    itemList.add(object);
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    for (Item item : itemList) {
      System.out.println(item.toString());
    }
  }

  @Override
  public List<Item> listAll(Long id) {
    return itemList;
  }

  @Override
  public void delete(Long id) {
    Optional<Item> item = this.find(id);

    if (item.isEmpty()) {
      System.out.println("Item not found");
    } else {
      System.out.println("Item with " + item.get().getCode() + " Was deleted ");
      itemList.remove(item.get());
    }
  }

  @Override
  public Optional<Item> find(Long id) {
    boolean state = false;
    for (Item item : itemList) {
      if (item.getCode().equals(id)) {
        System.out.println(":: Item was found ::");
        System.out.println(toString());

        return Optional.of(item);
      }
    }

    if (state == false) {
      System.out.println("Item doesn't was found");
    }

    return Optional.empty();
  }
}
