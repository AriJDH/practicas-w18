import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Cliente c1= new Cliente(23123454,"Juan Diaz");
        Cliente c2= new Cliente(43456432,"Lili Milla");
        Cliente c3= new Cliente(65324535, "Ana perez");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        System.out.println("Los daots de los clientes son:");
        for(Cliente c: clientes){
            System.out.println(c.toString());
        }

        c1.eliminarCliente(c1,clientes);

        System.out.println("Los daots de los clientes son:");
        for(Cliente c: clientes){
            System.out.println(c.toString());
        }

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar:");
        int dni = entrada.nextInt();
        c1.buscarCliente(dni,clientes);
*/
        List<Cliente> clientes = new ArrayList<Cliente>();
        List<Factura> facturas = new ArrayList<Factura>();
        Cliente cf = new Cliente() ;
        Scanner entrada = new Scanner(System.in);
        System.out.println("//----------------------------Supermercado El Econòmico----------------------------//");
        int opcion=0;
      do {
          do {
              System.out.println("----------------------------MENU----------------------------");
              System.out.println("----->Opcion 1: Crear Cliente");
              System.out.println("----->Opcion 2: Crear Factura");
              System.out.println("----->Opcion 3: Borrar Cliente");
              System.out.println("----->Opcion 4: Mostrar Clientes");
              System.out.println("----->Opcion 5: Mostrar Facturas");
              System.out.println("----->Opcion 99: Salir");
              System.out.println("--------**Ingrese una opciòn**---------");



              opcion = entrada.nextInt();

             if(opcion != 99 && (opcion < 0 || opcion > 5) )
                 System.out.println("Ingrese una opcion correcta");

              switch (opcion){
                  case 1:
                      System.out.println("Ingrese el DNI del cliente: ");
                      int dni = entrada.nextInt();
                      System.out.println("Ingrese el Nombre y Apellido del cliente: ");
                      entrada.nextLine();
                      String nya = entrada.nextLine();

                      Cliente cliente = new Cliente(dni,nya);
                      cliente.guardar(cliente,clientes);


                      break;
                  case 2:
                      List<Item> items = new ArrayList<Item>();
                      System.out.println("Ingrese el numero de la Factura: ");
                      int numero = entrada.nextInt();
                      System.out.println("Ingrese la cantidad de items a facturar: ");
                      int cant = entrada.nextInt();

                      for(int i=0;i<cant;i++){
                          System.out.println("Ingrese Codigo: ");
                          int codigo = entrada.nextInt();
                          System.out.println("Ingrese Nombre: ");
                          String nombre = entrada.nextLine();
                          entrada.nextLine();
                          System.out.println("Ingrese la cantidad del item: ");
                          int cantidadItem = entrada.nextInt();
                          System.out.println("Ingrese precio unitario; ");
                          double precio = entrada.nextDouble();
                          Item item = new Item(codigo,nombre,cantidadItem,precio);
                          item.guardar(item,items);
                      }

                      System.out.println("Ingrese el DNI del cliente: ");
                      int dnic = entrada.nextInt();

                      cf.setDni(dnic);
                      if(!cf.buscar(dnic, clientes)){
                          System.out.println("Ingrese el Nombre y Apellido del cliente: ");
                          entrada.nextLine();
                          String nyac = entrada.nextLine();
                          Cliente c = new Cliente(dnic,nyac);
                          cf.setDni(dnic);
                          cf.setNombreyApe(nyac);
                          cf.guardar(c,clientes);
                      }

                      double total = items.get(0).calcularTotal(items);
                      Factura fac = new Factura(cf,items,total);
                      facturas.add(fac);
                      break;

                  case 3:
                      System.out.println("Ingrese el DNI del cliente: ");
                      int dnib = entrada.nextInt();
                      clientes.get(0).borrar(cf.clienteBydni(dnib,clientes),clientes);
                      break;

                  case 4:
                      System.out.println("Los Clientes son: ");
                      if(!clientes.isEmpty()){
                          for (Cliente c: clientes){
                              System.out.println( c.toString());
                          }
                      }
                      else
                          System.out.println("No existe ningun cliente");

                      break;

                  case 5:
                      System.out.println("Las Facturas son: ");
                      if(!facturas.isEmpty()){
                          for (Factura f: facturas){
                              System.out.println(f.toString());
                          }
                      }
                      else
                          System.out.println("No Existe ninguna factura");
                      break;
              }

          }while(opcion != 99 && (opcion < 0 || opcion > 5) );


      }while (opcion != 99 );
    }
}