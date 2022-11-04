import clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> listCliente = new ArrayList<Cliente>();
        Scanner entrada = new Scanner(System.in);
        String dniAEliminar, dniABuscar;
        boolean seEncontroCliente = false;
        //Se crea clientes
        Cliente cliente = new Cliente("02158", "Valentina", "Lopez");
        Cliente cliente1 = new Cliente("54120", "Janeth", "Martinez");
        Cliente cliente2 = new Cliente("21255", "Abril", "Martinez");
        Cliente cliente3 = new Cliente("68412", "Alexander", "Martinez");
        listCliente.add(cliente);
        listCliente.add(cliente1);
        listCliente.add(cliente2);
        listCliente.add(cliente3);

        // muestraInformacionCliente
        for(Cliente client : listCliente){
            System.out.println("*****************************************");
            System.out.println("Se muestra informacion de clientes: " );
            System.out.println("*****************************************");
            System.out.println("dni: " + client.getDni());
            System.out.println("nombre " + client.getNombre());
            System.out.println("apellido " +client.getApellido());
        }

        //eliminaClientePorDNI
        System.out.println("*****************************************");
        System.out.println("Ingresa el valor del dni de la persona a eliminar");
        dniAEliminar = entrada.nextLine();
        for(Cliente c : listCliente){
            if(c.getDni().equals(dniAEliminar)){
                listCliente.remove(c);
                seEncontroCliente = true;
                break;
            }
        }
        if(seEncontroCliente == false){
            System.out.println("No se encontro al cliente a eliminar");
            System.out.println("*****************************************");
        }else{
            System.out.println("Se elimino al cliente con dni: " + dniAEliminar);
            System.out.println("*****************************************");
        }

        //buscaCliente(){

        System.out.println("*****************************************");
        System.out.println("Ingresa el valor del dni de la persona a buscar");
        dniABuscar = entrada.nextLine();
        seEncontroCliente = false;
        for(Cliente c : listCliente){
            if(c.getDni().equals(dniABuscar)){
                System.out.println("*****************************************");
                System.out.println("*****************************************");
                System.out.println("Se muestran los datos");
                System.out.println("DNI: "+c.getDni());
                System.out.println("Nombre: "+ c.getNombre());
                System.out.println("Apellido: "+c.getApellido());
                seEncontroCliente = true;
                break;
            }
        }
        if(seEncontroCliente == false){
            System.out.println("*****************************************");
            System.out.println("No se encontro al cliente");
        }else{
            System.out.println("*****************************************");
            System.out.println("Se encontro al cliente con dni: " + dniAEliminar);
        }
    }
}