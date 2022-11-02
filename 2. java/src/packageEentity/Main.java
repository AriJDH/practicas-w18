package packageEentity;

public class Main {
	
	public static void main(String[] args) {
		
		Ejecutivo ejecutivo = new Ejecutivo();
		
		Basic basic = new Basic();
		
		Cobradores cobradores = new Cobradores();
		
		ejecutivo.getDeposito().transaccionNoOK();
		ejecutivo.getDeposito().transaccionOK();
		ejecutivo.getTranferencia().transaccionOK();
		ejecutivo.getTranferencia().transaccionNoOK();
		
		basic.getPagoServicio().transaccionNoOK();
		basic.getRetiroEfectivo().transaccionOK();
		basic.getSaldo().transaccionNoOK();
		
		cobradores.getRetiroEfectivo().transaccionOK();
		cobradores.getSaldo().transaccionOK();
		
	}

}
