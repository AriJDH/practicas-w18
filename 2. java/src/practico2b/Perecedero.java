package practico2b;

public class Perecedero extends Producto{

	int diasPorCaducar;	

	public Perecedero(String nombre, double precio , int diasPorCaducar) {
		super(nombre, precio);
		this.diasPorCaducar = diasPorCaducar;
	}
	
	

	@Override
	double calcular(int cantidad) {
		double resultado = super.calcular(cantidad);
		
		switch (this.diasPorCaducar) {
		case 1:
			return resultado/4;
		case 2:
			return resultado/3;
		case 3:
			return resultado/2;
		default:
			break;
		}
		
		return 0.0;
	}



	@Override
	public String toString() {
		return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
	}

	public int getDiasPorCaducar() {
		return diasPorCaducar;
	}

	public void setDiasPorCaducar(int diasPorCaducar) {
		this.diasPorCaducar = diasPorCaducar;
	}
	
	
	
}
