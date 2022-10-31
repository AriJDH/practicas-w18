import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Nota: usare como clave en DNI y lo asociare a una lista de  string que tendra toda la informacion
* de cada participante(convenientemente lo convertire a int segun lo necesite(esto solo para tener una sola lista
* ya que solo permite datos homogeneos), entonces ->
* <DNI,[nro participante, monto, nombre, apellido, edad, celular, nro emergencia, grupo sanguineo]> ).
* */

public class CarreraDeLaSelva {
    //nro de inscriptos es para asignarsela a cada participante->difiere de la cantidad
    int numeroInscriptos=0;

    Map<Integer, String[]> circuitoChico= new HashMap<>();     //1
    Map<Integer, String[]> circuitoMedio= new HashMap<>();    //2
    Map<Integer, String[]> circuitoAvanzado= new HashMap<>(); //3

    public void inicializar(){
        inscribirParticipante(1,45111111,"Juan","Perez",17,2911111,2911112,"A");
        inscribirParticipante(2,38111189,"Jose","Martinez",25,2911122,2911123,"B");
        inscribirParticipante(1,46111112,"Marcos","Perez",16,2911113,2911112,"A");
        inscribirParticipante(3,36111111,"Ana","Fernandez",28,2915555,2911156,"B");
        inscribirParticipante(2,37177811,"Maria","Castillo",38,29144441,2911442,"A");
        inscribirParticipante(3,35111111,"Facundo","Bazan",30,29113333,2911332,"A");
    }

    public void inscribirParticipante(int circuito, int dni, String nombre, String apellido, int edad,
                                      int celular, int nroEmergencia, String grupoSanguineo){
        if (!estaInscripto(dni)){
            if (circuito==1)
                circuitoChico.put(dni, registrarDatos(circuito,nombre,apellido,edad,celular,nroEmergencia,grupoSanguineo));
            else{
                if (circuito==2)
                    circuitoMedio.put(dni, registrarDatos(circuito,nombre,apellido,edad,celular,nroEmergencia,grupoSanguineo));
                else
                    circuitoAvanzado.put(dni, registrarDatos(circuito,nombre,apellido,edad,celular,nroEmergencia,grupoSanguineo));
            }
        }
        else
            System.out.printf("ERROR: Este participante ya se encuentra inscripto.");
    }
    public String[] registrarDatos(int circuito, String nombre, String apellido, int edad,
                                          int celular, int nroEmergencia, String grupoSanguineo) {
        String[] nuevo = new String[8];
        numeroInscriptos++;
        nuevo[0]= toString(numeroInscriptos);
        nuevo[1]=toString(calcularMonto(circuito,edad));
        nuevo[2]=nombre;
        nuevo[3]=apellido;
        nuevo[4]=toString(edad);
        nuevo[5]=toString(celular);
        nuevo[6]=toString(nroEmergencia);
        nuevo[7]=grupoSanguineo;
        return nuevo;
    }

    public boolean estaInscripto(int dni){
        return circuitoChico.containsKey(dni) || circuitoMedio.containsKey(dni) || circuitoAvanzado.containsKey(dni);
    }

    public void eliminarInscripto(int circuito, int dni){
        if (circuito==1)
            circuitoChico.remove(dni);
        else{
            if (circuito==2)
                circuitoMedio.remove(dni);
            else
                circuitoAvanzado.remove(dni);
        }
    }

    public void mostrarInscriptos(){
        System.out.println("------------ESTOS SON LOS INSCRIPTOS---------");
        System.out.println("-CIRCUITO CHICO-");
        for(Map.Entry<Integer,String[]> participante: circuitoChico.entrySet())
        {
            imprimir(participante.getKey(), participante.getValue());
        }
        System.out.println("-CIRCUITO MEDIO-");
        for(Map.Entry<Integer,String[]> participante: circuitoMedio.entrySet())
        {
            imprimir(participante.getKey(), participante.getValue());
        }
        System.out.println("-CIRCUITO AVANZADO-");
        for(Map.Entry<Integer,String[]> participante: circuitoAvanzado.entrySet())
        {
            imprimir(participante.getKey(), participante.getValue());
        }
    }

    private void imprimir(int dni,String[]datos){
        System.out.println("Nro participante: "+datos[0]+", DNI: "+dni+", Nombre: "+datos[2]+
                ", Apellido: "+datos[3]+", Edad: "+datos[4]+", Celular: "+datos[5]+", Emergencia: "+datos[6]+", G.S: "+datos[7]+", Monto: $"+datos[1]+".");
    }
    private String toString(int monto) {
        return String.valueOf(monto);
    }

    public int calcularMonto(int circuito, int edad){
        int monto=0;
        if (edad>=18){
            if (circuito==1)
                monto=1500;// circuito chico
            else {
                if (circuito==2)
                    monto=2300;// circuito medio
                else
                    monto=2800;   // circuito avanzado
            }
        }
        else{
            if(circuito==1) // circuito chico
                monto=1300;
            else
                monto=2000; // circuito medio
        }
        return monto;
    }

}
