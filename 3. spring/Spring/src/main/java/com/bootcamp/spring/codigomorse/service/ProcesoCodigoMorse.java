package com.bootcamp.spring.codigomorse.service;

import org.springframework.stereotype.Service;

@Service
public class ProcesoCodigoMorse {
	
	public String codigoMorseParseado(String morse) {
		String texto = "";
		String[] arrayMorse = morse.split("   ");
		
		for(int i = 0; i < arrayMorse.length; i++) {
			String[] letras = arrayMorse[i].split(" ");
			for(int b = 0; b < letras.length; b++) {
				
				texto += letrasYNumeroParseados(letras[b]);
				System.out.println(texto);
			}
			texto += " ";
			
		}
		
		return texto;
	}
	
	private String letrasYNumeroParseados(String texto) {
		
		switch (texto) {
		case ".-":
			return "A";
		case "-...":
			return "B";
		case "-.-.":
			return "C";
		case "-..":
			return "D";
		case ".":
			return "E";
		case "..-.":
			return "F";
		case "--.":
			return "G";
		case "....":
			return "H";
		case "..":
			return "I";
		case ".---":
			return "J";
		case "-.-":
			return "K";
		case ".-..":
			return "L";
		case "--":
			return "M";
		case "-.":
			return "N";
		case "---":
			return "O";
		case ".--.":
			return "P";
		case "--.-":
			return "Q";
		case ".-.":
			return "R";
		case "...":
			return "S";
		case "-":
			return "T";
		case "..-":
			return "U";
		case "...-":
			return "V";
		case ".--":
			return "W";
		case "-..-":
			return "X";
		case "-.--":
			return "Y";
		case "--..":
			return "Z";
		case "   ":
			return " ";
		case " ":
			return "";

		default:
			break;
		}
		
		
		return "";
	}

}
