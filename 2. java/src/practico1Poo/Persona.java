package practico1Poo;

public class Persona {

	public Persona() {}
	
	
	public Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}


	public Persona(String nombre, int edad, String dni, float peso, float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.peso = peso;
		this.altura = altura;
	}
	
	private String nombre;
	private int edad;
	private String dni;
	private float peso;
	private float altura;
	
	public int calcularIMC() {
		
		double resultado = this.peso/(Math.pow(this.altura, 2));
		
		if(resultado < 20)
			return -1;
		else if(resultado <= 25)
			return 0;
		else
			return 1;
		
	}
	
	public boolean esMayorDeEdad() {
		
		return this.edad >=18?true:false;
	}
	
	private String peso() {
		
		int resultado = calcularIMC();
		
		if(resultado == -1)
			return "Esta persona tiene bajo peso";
		else if(resultado == 0)
			return "Esta persona tiene peso saludable";
		
		
		return "Esta persona tiene sobrepeso";
	}
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", peso=" + peso + ", altura=" + altura
				+ "] \nEsta persona es " + (esMayorDeEdad()?"Mayor de edad. ":"Menor de edad. ") + peso();
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	
}
