public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void transaccionOk(){
        System.out.println("La transaccion se realizo correctamente.");
    }

    @Override
    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido realizarse.");
    }

    @Override
    public void realizarConsultaDeSaldo(){
        System.out.println("Realizando consulta de saldo ...");
    }

    @Override
    public void realizarPagoDeServicios(){
        System.out.println("Realizando pago de servicios ...");
    }

    @Override
    public void realizarRetiroDeEfectivo(){
        System.out.println("Realizando retiro de efectivo ...");
    }




}
