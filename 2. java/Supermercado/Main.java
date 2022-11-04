package Supermercado;

import Supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Cliente cliente1 = new Cliente("Pedro","Robaina","42931180");
        Cliente cliente2 = new Cliente("ricardo","Mollo","42480");
        Cliente cliente3 = new Cliente("Felipe","Pigna","5049289");

        List<Cliente> clientesSupermercado = new ArrayList<Cliente>();
        clientesSupermercado.add(cliente1);
        clientesSupermercado.add(cliente2);
        clientesSupermercado.add(cliente3);

        for(Cliente c: clientesSupermercado){
            System.out.println(c.getNombre() + " " + c.getApellido() + " " + c.getDni());
        }

        Scanner teclado = new Scanner(System.in);

        System.out.println("Que desea hacer 1) Borrar persona con dni 2)Encontrar persona 3) Salir");
        int opcion = teclado.nextInt();

        switch(opcion){
            case 1:

                System.out.println("--- Seleccione el cliente a borrar ---");
                String dniBorrar = teclado.next();
                int count = 0;

                for(Cliente c: clientesSupermercado){
                    if(c.getDni().equals(dniBorrar)){
                        clientesSupermercado.remove(c);
                        for(Cliente a: clientesSupermercado) {
                            System.out.println(a.getNombre() + " " + a.getApellido() + " " + a.getDni());
                        }
                        count = 1;
                    }
                }
                if (count == 0){
                    System.out.println("No se pudo encontrar el cliente");
                }
                break;
            case 2:
                System.out.println("--- Seleccione el cliente a encontrar ---");
                String dniEncontrar = teclado.next();
                int cont = 0;

                for(Cliente a: clientesSupermercado){
                    if(a.getDni().equals(dniEncontrar)) {
                        clientesSupermercado.remove(a);
                        for (Cliente z : clientesSupermercado) {
                            System.out.println(a.getNombre() + " " + z.getApellido() + " " + z.getDni());
                        }
                        cont = 1;
                    }
                    } if(cont == 0){
                        System.out.println("No se pudo encontrar");
                    }
                 break;
            case 3:
                System.exit(0);

        }


/*continua en parte 2*/

    }
}
