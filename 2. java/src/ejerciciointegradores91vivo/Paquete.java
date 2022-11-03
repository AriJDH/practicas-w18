package ejerciciointegradores91vivo;

public class Paquete {
	
	public Paquete(boolean hotel, boolean comida, boolean boleto, boolean transporte) {
		super();
		this.hotel = hotel;
		this.comida = comida;
		this.boleto = boleto;
		this.transporte = transporte;
	}

	private boolean hotel, comida, boleto, transporte;

	public boolean esCompleto() {
		
		if(isBoleto() && isComida() && isHotel() && isTransporte())
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Paquete [hotel=" + (hotel?"Si":"No") + ", comida=" + (comida?"Si":"No")
				+ ", boleto=" + (boleto?"Si":"No") + ", transporte=" + (transporte?"Si":"No")
				+ "]";
	}

	public boolean isHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public boolean isComida() {
		return comida;
	}

	public void setComida(boolean comida) {
		this.comida = comida;
	}

	public boolean isBoleto() {
		return boleto;
	}

	public void setBoleto(boolean boleto) {
		this.boleto = boleto;
	}

	public boolean isTransporte() {
		return transporte;
	}

	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	
	

}
