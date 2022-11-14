public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo {

    @Override
    public void transaccionOk(){
        System.out.println("La transaccion se realizo correctamente.");
    }

    @Override
    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido realizarse.");
    }

    @Override
    public void realizarRetiroDeEfectivo(){
        System.out.println("Realizando retiro de efectivo ...");
    }

    @Override
    public void realizarConsultaDeSaldo(){
        System.out.println("Realizando consulta de saldo ...");
    }

}
