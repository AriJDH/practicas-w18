package Repository;

import Entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerRepository implements Crud<Customer>{
    List<Customer>customers=new ArrayList<>();
    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void findAll() {

        customers.stream().forEach(System.out::println);
    }

    @Override
    public void deleteOne(String dni) {
        List<Customer> customer22= getCustomers(dni);
        customer22.forEach(customers::remove);
        findAll();

    }

    @Override
    public void findOne(String dni) {

        Optional<List<Customer>> customer1= Optional.ofNullable(getCustomers(dni));
        customer1.ifPresentOrElse(
                System.out::println
                ,()-> System.out.println("Customer does not exist")
        );


    }
    private List<Customer>getCustomers(String dni){
        List<Customer>customerList= customers.stream()
                .filter(customer ->
                        customer.getDni().equals(dni))
                .collect(Collectors.toList());
        if (customerList.size()!=0){
            return customerList;
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
