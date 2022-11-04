package meli.bootcamp.clases;

public class DetalleFactura {
    private int ctdProducto;
    private Item item;

    public DetalleFactura(int ctdProducto, Item item)
    {
        this.ctdProducto = ctdProducto;
        this.item = item;
    }

    public int getCtdProducto()
    {
        return ctdProducto;
    }

    public Item getItem()
    {
        return item;
    }
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("DetalleFactura{");
        sb.append("ctdProducto=").append(ctdProducto);
        sb.append(", item=").append(item);
        sb.append('}');
        return sb.toString();
    }
}
