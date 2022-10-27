import java.util.*;

public class EstDinamica {
    private String categoria, dni, nombre, apellido, edad, celular, numEmerg, GS;
    private int numeroParticipante = 0;
    HashMap <Integer, Map<String, String>> circuitoChico = new HashMap<>();
    HashMap <Integer, Map<String, String>> circuitoMedio = new HashMap<>();
    HashMap <Integer, Map<String, String>> circuitoAvanzado = new HashMap<>();

    public static void main(String[] args) {
        int op;
        int numParticipante;
        EstDinamica registro = new EstDinamica();
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("1 - Inscribir participante");
            System.out.println("2 - Mostrar participantes por categoria");
            System.out.println("3 - Desinscribir participante");
            System.out.println("0 - Salir");
            System.out.println("Ingrese una opcion");

            op = teclado.nextInt();

            switch (op){
                case 1:
                    registro.cargar();
                    break;
                case 2:
                    System.out.println("Mostrar los inscriptos a la categoria: 1 (circuito chico), 2 (circuito medio), 3 (circuito avanzado)");
                    int categoria = teclado.nextInt();
                    registro.mostrar(categoria);
                    break;
                case 3:
                    System.out.println("Desinscribir al participante: ");
                    numParticipante = teclado.nextInt();
                    System.out.println("De la categoria: ");
                    int cat = teclado.nextInt();
                    registro.desinscribir(numParticipante, cat);
                    break;
                case 0:
                    return;
            }
        }while(op !=0);
    }

    public void cargar(){
        System.out.println("Inscribir a un nuevo parcitipante");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Categoria: 1 (circuito chico), 2 (circuito medio), 3 (circuito avanzado)");
        categoria = teclado.nextLine();
        System.out.println("dni: ");
        dni = teclado.nextLine();
        System.out.println("nombre: ");
        nombre = teclado.nextLine();
        System.out.println("apellido: ");
        apellido = teclado.nextLine();
        System.out.println("edad: ");
        edad = teclado.nextLine();
        System.out.println("celular: ");
        celular = teclado.nextLine();
        System.out.println("numero de emergencia: ");
        numEmerg = teclado.nextLine();

        if(determinarMonto(Integer.parseInt(categoria), Integer.parseInt(edad))){
            numeroParticipante ++;

            Map<String, String> participante = new HashMap<>();
            participante.put("dni", dni);
            participante.put("nombre", nombre);
            participante.put("apellido", apellido);
            participante.put("edad", edad);
            participante.put("celular", celular);
            participante.put("numEmergencia", numEmerg);


            if(categoria.equals("1")){
                circuitoChico.put(numeroParticipante, participante);
            }
            if(categoria.equals("2")){
                circuitoMedio.put(numeroParticipante, participante);
            }
            if(categoria.equals("3")){
                circuitoAvanzado.put(numeroParticipante, participante);
            }
        }
    }

    public void mostrar(int categoria){
        if(categoria == 1){
            recorrerMap(circuitoChico);
        }
        if(categoria == 2){
            recorrerMap(circuitoMedio);
        }
        if(categoria == 3){
            recorrerMap(circuitoAvanzado);
        }
    }

    private void recorrerMap(HashMap<Integer, Map<String, String>> circuito) {
        if(circuito == circuitoChico){
            for(Map.Entry<Integer, Map<String, String>> participante : circuitoChico.entrySet()){
                System.out.println("Participante numero: " + participante.getKey());
                System.out.println("Nombre: " + participante.getValue().get("nombre"));
                System.out.println(participante.getValue());
            }
        }

        if(circuito == circuitoMedio){
            for(Map.Entry<Integer, Map<String, String>> participante : circuitoMedio.entrySet()){
                System.out.println("Participante numero: " + participante.getKey());
                System.out.println("Nombre: " + participante.getValue().get("nombre"));
                System.out.println(participante.getValue());
            }
        }

        if(circuito == circuitoAvanzado){
            for(Map.Entry<Integer, Map<String, String>> participante : circuitoAvanzado.entrySet()){
                System.out.println("Participante numero: " + participante.getKey());
                System.out.println("Nombre: " + participante.getValue().get("nombre"));
                System.out.println(participante.getValue());
            }
        }
    }

    public void desinscribir(int numParticipante, int cat){
        if(cat == 1){
            circuitoChico.remove(numParticipante);
        }
        if(cat == 2){
            circuitoMedio.remove(numParticipante);
        }
        if(cat == 3){
            circuitoAvanzado.remove(numParticipante);
        }
    }

    public boolean determinarMonto(int categoria, int edad){
        if(categoria == 1 && edad < 18){
            System.out.println("El monto a pagar es de $1300");
        }
        if(categoria == 1 && edad > 18){
            System.out.println("El monto a pagar es de $2000");
        }
        if(categoria == 2 && edad < 18){
        System.out.println("El monto a pagar es de $1500");
        }
        if(categoria == 2 && edad > 18){
            System.out.println("El monto a pagar es de $2300");
        }
        if(categoria == 3 && edad < 18){
            System.out.println("No se permite inscripciones a menores de 18 anos");
            return false;
        }
        if(categoria == 3 && edad > 18){
            System.out.println("El monto a pagar es de $2800");
        }
        return true;
    }
}
