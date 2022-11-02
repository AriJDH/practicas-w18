package poo;

public class Jaguar {
	
	private int edad;
	private float peso;
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Jaguar [edad=" + edad + ", peso=" + peso + "]";
	}
	
	
	

}
