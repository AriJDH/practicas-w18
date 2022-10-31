public class Main {
    public static void main(String[] args) {

        CarreraDeLaSelva carrera= new CarreraDeLaSelva();
        carrera.inicializar();
        carrera.mostrarInscriptos();

        System.out.println("####################### a) INSCRIBIR NUEVO PARTICIPANTE EN UNA CATEGORIA #######################");
        System.out.println("Intento inscribir al circuito chico a un participante que ya esta en las listas: Facundo Bazan(DNI: 35111111 )");
        carrera.inscribirParticipante(1,35111111,"Facundo","Bazan", 30, 29113333,2911332,"A");
        System.out.println("Intento inscribir al circuito avanzado a una nueva participante: Belen Gutierrez(DNI: 35118881 )");
        carrera.inscribirParticipante(3,35118881,"Belen","Gutierrez", 30, 29117773,2917732,"B");

        System.out.println("####################### b) MOSTRAR PARTICIPANTES POR CATEGORIA #######################");
        carrera.mostrarInscriptos();

        System.out.println("####################### c) DESINSCRIBIR PARTICIPANTES DE UNA CATEGORIA #######################");
        System.out.println("Elimino al participante Jose Martinez del circuito medio (DNI:38111189)");
        carrera.eliminarInscripto(2,38111189);
        carrera.mostrarInscriptos();

        System.out.println("####################### d) CALCULAR MONTO A PAGAR #######################");
        System.out.println("Calculo el monto para un participante  de 21 años que quiere inscribirse al circuito chico.");
        int monto = carrera.calcularMonto(1,21);
        System.out.println("Monto a abonar: $"+monto);
    }
}