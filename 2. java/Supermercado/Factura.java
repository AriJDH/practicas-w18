package Supermercado;

import Supermercado.Cliente;

import java.util.List;
/*Por otro lado, las facturas que se generan cuando n cliente
        hace una compra contienen a un cliente, una lista de ítems y el total de la compra.*/

public class Factura {

    private Cliente cliente;
    private List<Item> items;
}
