package packageEentity;

public class Cobradores {
	
	private ConsultaDeSaldo saldo;
	
	private RetiroDeEfectivo retiroEfectivo;

	public ConsultaDeSaldo getSaldo() {
		if(saldo == null)
			return saldo = new ConsultaDeSaldo();
		return saldo;
	}

	public void setSaldo(ConsultaDeSaldo saldo) {
		this.saldo = saldo;
	}

	public RetiroDeEfectivo getRetiroEfectivo() {
		if(retiroEfectivo == null)
			return retiroEfectivo = new RetiroDeEfectivo();
		return retiroEfectivo;
	}

	public void setRetiroEfectivo(RetiroDeEfectivo retiroEfectivo) {
		this.retiroEfectivo = retiroEfectivo;
	}
	
	

}
