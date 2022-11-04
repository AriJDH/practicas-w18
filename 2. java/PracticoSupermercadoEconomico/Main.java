package SupermercadoEconomico;

import SupermercadoEconomico.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("123123123", "Raul", "Tevez");
        Cliente cliente2 = new Cliente("345345345", "Mario", "Artaza");
        Cliente cliente3 = new Cliente("567567567", "Carlos", "Zocasa");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for(Cliente cliente : listaClientes){
            System.out.println("DNI: "+cliente.getDni());
            System.out.println("Nombre: "+cliente.getNombre());
            System.out.println("Apellido: "+cliente.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el DNI de la persona a borrar: ");
        String dniBorrar = teclado.next();

        boolean flag = false;
        for(Cliente cliente : listaClientes){
            if(dniBorrar.equals(cliente.getDni())){
                listaClientes.remove(cliente);
                flag = true;
                break;
            }
        }

        if(flag == true){
            System.out.println("Cliente borrado correctamente!");
        }else{
            System.out.println("No se encontró el cliente a borrar!");
        }

        System.out.println("Ingresa el DNI del cliente a buscar: ");
        String dniBuscar = teclado.next();

        flag = false;
        for(Cliente clientes : listaClientes){
            if(dniBuscar.equals(clientes.getDni())){
                System.out.println("----------Cliente encontrado: ----------");
                System.out.println("DNI: "+ clientes.getDni());
                System.out.println("Nombre: "+ clientes.getNombre());
                System.out.println("Apellido: "+clientes.getApellido());
                break;
            }
        }

        if(flag == false){
            System.out.println("No se pudo encontrar al cliente!");
        }
    }
}
