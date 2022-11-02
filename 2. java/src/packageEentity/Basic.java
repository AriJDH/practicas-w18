package packageEentity;

public class Basic {
	
	private ConsultaDeSaldo saldo;
	
	private PagoDeServicios pagoServicio;
	
	private RetiroDeEfectivo retiroEfectivo;

	public ConsultaDeSaldo getSaldo() {
		if(saldo == null)
			return saldo = new ConsultaDeSaldo();
		return saldo;
	}

	public void setSaldo(ConsultaDeSaldo saldo) {
		this.saldo = saldo;
	}

	public PagoDeServicios getPagoServicio() {
		if(pagoServicio == null)
			return pagoServicio = new PagoDeServicios();
		return pagoServicio;
	}

	public void setPagoServicio(PagoDeServicios pagoServicio) {
		this.pagoServicio = pagoServicio;
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
