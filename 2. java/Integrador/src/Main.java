import Entity.Customer;
import Entity.Product;
import Entity.Ticket;
import Repository.CustomerRepository;
import Repository.ProductRepository;
import Repository.TicketRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer1=new Customer("21435678","Felipe","Mena");
        Customer customer2=new Customer("12435678","Carla","Morrison");
        Customer customer3=new Customer("17435678","Laura","Perez");
        CustomerRepository repository=new CustomerRepository();
        repository.create(customer1);
        repository.create(customer2);
        repository.create(customer3);

        System.out.println("Recorrer lista de clientes");
        repository.findAll();

        System.out.println("Eliminar cliente por dni y mostrar el resto");
        repository.deleteOne("17435678");

        System.out.println("Buscar cliente por dni. Si existe mostrarlo, sino mensaje de excepción");
        repository.findOne("12435678");
        repository.findOne("17435678");

        Product product=new Product("123","Phone",2,200.);
        Product product2=new Product("123","Phone",1,100.);
        Product product3=new Product("123","Phone",3,300.);

        ProductRepository productRepository= new ProductRepository();
        productRepository.create(product);
        productRepository.create(product2);
        productRepository.create(product3);


        System.out.println("Mostrar tickets");
        TicketRepository ticketRepository=new TicketRepository();
        Ticket ticket=new Ticket(customer1,productRepository.getProducts());
        ticketRepository.create(ticket);
        ticketRepository.findAll();
    }
}
