package mercadolibre.practicos.java;

import java.util.ArrayList;
import java.util.Scanner;

public class EstructurasDinamicasMain {
	private static int contador = 1;
	private static ArrayList<ArrayList<String>> listParticipantesChico = new ArrayList<>();
	private static ArrayList<ArrayList<String>> listParticipantesMedio = new ArrayList<>();
	private static ArrayList<ArrayList<String>> listParticipantesAvanzado = new ArrayList<>();
	

	public static void main(String[] args) {

		Scanner teclado1 = new Scanner(System.in);
		int opcion;
		boolean recorro = true;
		do {
			teclado1 = new Scanner(System.in);
			System.out.println(
					"Ingrese que desea hacer: \n1- Inscribir Participante \n2-Mostrar inscriptos \n3-Desencribir Participante\n4-Calcular"
							+ " Costo de inscripcion");
			opcion = teclado1.nextInt();
			switch (opcion) {
			case 1:
				loadDataParticipante();
				break;
			case 2:
				mostrarParticipantesInscriptos();
				break;
			case 3:
				eliminarParticipanteInscripto();
				break;
			default:
				recorro = false;
				break;
			}
		} while (recorro);
		
		teclado1.close();

	}
	
	private static void eliminarParticipanteInscripto() {
		int id;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese Id del participante que quiera eliminar: ");
		id = teclado.nextInt();
		boolean flag = true;
		
		if(recorroListaParaEliminarParticipante(listParticipantesAvanzado, id))
			System.out.println("Se elimino el participante del circuito Avanzado con id = " + id);
		else if(recorroListaParaEliminarParticipante(listParticipantesChico, id))
			System.out.println("Se elimino el participante del circuito Chico con id = " + id);
		else if(recorroListaParaEliminarParticipante(listParticipantesMedio, id)) {
			System.out.println("Se elimino el participante del circuito Medio con id = " + id);
		}else
			System.out.println("No se encontro participante con id: " + id);
	}

	private static void mostrarParticipantesInscriptos() {
		int opcion;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Que categoria quiere ver: \nRECUERDE, SI NO INGRESA"
				+ " UNA OPCION CORRECTA \n SE MOSTRARA POR DEFECTO AL CIRCUITO CHICO \n "
				+ "Opcion 1 Circuito Chico \n Opcion 2 Circutio medio \n Opcion 3 Circuito Avanzado");
		opcion = teclado.nextInt();

		if (opcion == 2)
			pintoParticipantesInscriptos(listParticipantesMedio);
		else if (opcion == 3)
			pintoParticipantesInscriptos(listParticipantesAvanzado);
		else
			pintoParticipantesInscriptos(listParticipantesChico);
		
		

	}
	
	private static boolean recorroListaParaEliminarParticipante(ArrayList<ArrayList<String>> listParticipantes, int id) {

		for (int i = 0; i < listParticipantes.size(); i++) {
			String datosAMostrar = "";
			int idParticpiante = Integer.parseInt(listParticipantes.get(i).get(8));
			if(id == idParticpiante) {
				listParticipantes.remove(i);
				return true;
			}
		

		}
		return false;

	}

	private static void pintoParticipantesInscriptos(ArrayList<ArrayList<String>> listParticipantes) {

		for (int i = 0; i < listParticipantes.size(); i++) {
			String datosAMostrar = "";
			for (int b = 0; b < listParticipantes.get(i).size(); b++) {
				datosAMostrar += listParticipantes.get(i).get(b) + " ";
			}
			System.out.println(datosAMostrar + "\n");

		}

	}

	private static void loadDataParticipante() {

		String data = "";
		int opcion;
		ArrayList<String> participante = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);

		System.out.println("A que categoria quiere inscribir el participante: \nRECUERDE, SI NO INGRESA"
				+ " UNA OPCION CORRECTA \n SE AGREGARA POR DEFECTO AL CIRCUITO CHICO \n "
				+ "Opcion 1 Circuito Chico \n Opcion 2 Circutio medio \n Opcion 3 Circuito Avanzado");
		opcion = teclado.nextInt();
		participante.add(String.valueOf(opcion));

		System.out.println("Ingrese DNI: ");
		data = teclado.next();
		participante.add(data);

		System.out.println("Ingrese Nombre: ");
		data = teclado.next();
		participante.add(data);

		System.out.println("Ingrese Apellido: ");
		data = teclado.next();
		participante.add(data);
		int firsTime = 1;
		int edad = 0;
		do {
			if (firsTime == 1)
				System.out.println("Ingrese edad: ");
			else
				System.out.println("RECUERDE DEBE DE SER MAYOR DE 18 ANIOS PARA EL CIRCUITO AVANZADO \nIngrese edad: ");
			data = teclado.next();
			participante.add(data);
			edad = Integer.parseInt(participante.get(4));
			firsTime++;
		} while (opcion == 3 && edad < 18);

		System.out.println("Ingrese celular: ");
		data = teclado.next();
		participante.add(data);

		System.out.println("Ingrese numero de emrgencia: ");
		data = teclado.next();
		participante.add(data);

		System.out.println("Ingrese Gruppo sanguineo: ");
		data = teclado.next();
		participante.add(data);

		participante.add(contador + "");

		calcularTotal(opcion,participante);

		if (opcion == 2) {
			listParticipantesMedio.add(participante);
		} else if (opcion == 3) {
			listParticipantesAvanzado.add(participante);
		} else {
			listParticipantesChico.add(participante);
		}
		System.out.println("Quedo inscripto! Debe abonar un total de " + participante.get(participante.size() - 1));
		
		++contador;
		

	}

	private static void calcularTotal(int opcion, ArrayList<String> participante) {
		int edad = Integer.parseInt(participante.get(4));
		String abono = "";
		if (opcion == 2) {
			if (edad < 18) {
				participante.add("$2000");
			} else {
				participante.add("$2300");
			}
		} else if (opcion == 3) {
			participante.add("$2800");
		} else {
			if (edad < 18) {
				participante.add("$1300");
			} else {
				participante.add("$1500");
			}
		}

	}

}
