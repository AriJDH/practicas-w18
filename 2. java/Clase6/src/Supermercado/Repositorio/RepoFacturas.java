package Supermercado.Repositorio;

import Supermercado.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepoFacturas implements IRepositorio <Factura>{
    List<Factura> listaFacturas = new ArrayList<>();
    private static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Factura create(Factura factura) {
        if(factura.getIdFactura() == null){
            Factura nuevaFactura = new Factura(factura.getCliente(), factura.getListaItems());
            long id = count.incrementAndGet();

            nuevaFactura.setIdFactura(id);
            this.listaFacturas.add(nuevaFactura);
            factura.setIdFactura(id);

            return factura;
        }else{
            throw new IllegalArgumentException(String.format("La factura ya existe en la lista"));
        }
    }

    @Override
    public Factura update(Factura factura) {
        for(Factura storedFactura: listaFacturas){
            if(storedFactura.getIdFactura() == factura.getIdFactura()){
                storedFactura.setListaItems(factura.getListaItems());
                storedFactura.setTotalCompra(factura.getTotalCompra());

                return factura;
            }
        }
        return null;
    }

    @Override
    public Factura read(Long id) {
        for(Factura storedFactura : listaFacturas){
            if(storedFactura.getIdFactura() == id){
                return storedFactura;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        for(int i=0; i<this.listaFacturas.size(); i++){
            if(listaFacturas.get(i).getIdFactura() == id){
                listaFacturas.remove(i);
            }
        }
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
}
