package packageEentity;

public class Ejecutivo {
	
	private Deposito deposito;
	
	private Transferencia tranferencia;

	public Deposito getDeposito() {
		if(deposito == null)
			return deposito = new Deposito();
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Transferencia getTranferencia() {
		if(tranferencia == null)
			return tranferencia = new Transferencia();
		return tranferencia;
	}

	public void setTranferencia(Transferencia tranferencia) {
		this.tranferencia = tranferencia;
	}
	
	

}
