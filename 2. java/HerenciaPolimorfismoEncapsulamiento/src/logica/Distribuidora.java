package Logica;

public class Distribuidora {
    private Producto []listProducts;

    public Distribuidora() {
        this.listProducts = new Producto[10];
        this.init();
    }

    public void init(){
        for(int i = 0; i < 5; i++){
            this.listProducts[i] = new Perecedero("nombre " + i, Math.random()*1000, i+1);
            this.listProducts[i+5] = new NoPerecedero("nombre " + i, Math.random()*10000, "tipo " + i);
        }
    }

    public Producto[] getListProducts() {
        return this.listProducts;
    }
}
