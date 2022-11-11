package com.covid.DTO;

public class PersonaConSintomaDTO {
	public PersonaConSintomaDTO() {
	}
	
	public PersonaConSintomaDTO(String nombrePersona, String apellidoPersona, String nombreSintoma, int reisoSintoma) {
		super();
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.nombreSintoma = nombreSintoma;
		this.reisoSintoma = reisoSintoma;
	}
	
	private String nombrePersona;
	private String apellidoPersona;
	private String nombreSintoma;
	private int reisoSintoma;
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public String getNombreSintoma() {
		return nombreSintoma;
	}
	public void setNombreSintoma(String nombreSintoma) {
		this.nombreSintoma = nombreSintoma;
	}
	public int getReisoSintoma() {
		return reisoSintoma;
	}
	public void setReisoSintoma(int reisoSintoma) {
		this.reisoSintoma = reisoSintoma;
	}

}
