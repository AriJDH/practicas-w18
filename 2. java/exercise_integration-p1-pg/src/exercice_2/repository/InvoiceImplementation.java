package exercice_2.repository;

import exercice_2.model.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceImplementation implements CRUDRepository<Invoice> {
  public List<Invoice> invoiceList = new ArrayList<Invoice>();

  @Override
  public void save(Invoice object) {
    // TODO Auto-generated method stub
    invoiceList.add(object);
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    for (Invoice invoice : invoiceList) {
      System.out.println(invoice.toString());
    }
  }

  @Override
  public List<Invoice> listAll(Long id) {
    return invoiceList;
  }

  @Override
  public void delete(Long id) {
    Optional<Invoice> invoice = this.find(id);

    if (invoice.isEmpty()) {
      System.out.println("Invoice not found");
    } else {
      System.out.println(
        "Invoice with " + invoice.get().getId() + " Was deleted "
      );
      invoiceList.remove(invoice.get());
    }
  }

  @Override
  public Optional<Invoice> find(Long id) {
    boolean state = false;
    for (Invoice invoice : invoiceList) {
      if (invoice.getId().equals(id)) {
        System.out.println(":: Invoice was found ::");
        System.out.println(toString());

        return Optional.of(invoice);
      }
    }

    if (state == false) {
      System.out.println("Invoice doesn't was found");
    }

    return Optional.empty();
  }
}
