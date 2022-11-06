package Repository;

import Entity.Customer;
import Entity.Product;
import Entity.Ticket;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketRepository implements Crud<Ticket> {

    List<Ticket>tickets=new ArrayList<>();
    CustomerRepository customerRepository=new CustomerRepository();
    @Override
    public void create(Ticket ticket) {
        ticket.setTotal(calcularTotal(ticket));
        tickets.add(ticket);
    }

    @Override
    public void findAll() {
        tickets.stream().forEach(System.out::println);
    }

    @Override
    public void deleteOne(String dni) {

    }

    @Override
    public void findOne(String dni) {

    }
    public Double calcularTotal(Ticket ticket){

        return ticket.getProducts()
                .stream().map(p->p.getUnitCost()*p.getAmount())
                .reduce(Double::sum).orElse(0.);

    }
    private void validCustomer(Customer customer){
        Optional<Customer> customerrr=customerRepository.getCustomers().stream().filter(customer1 -> customer1.getDni().equals(customer)).findFirst();
        customerrr.ifPresentOrElse(c-> System.out.println(c.getName()+" is already added to the list"),
                ()->customerRepository.create(customer));
    }
}
