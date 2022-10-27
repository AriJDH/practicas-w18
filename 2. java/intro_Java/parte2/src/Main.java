/*Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como “Carrera de la Selva”.
   La competencia cuenta con 3 categorías dependiendo de su dificultad:
        Circuito chico: 2 km por selva y arroyos.
        Circuito medio: 5 km por selva, arroyos y barro.
        Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.
   Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar los siguientes datos:
    dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
   A cada inscripto, a la vez, se le asigna un número de participante consecutivo con respecto a la inscripción anterior;
   por ejemplo, si un participante se inscribe y el anterior fue el número 36, se le va a asignar el número 37.
   Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen en cuenta los siguientes valores:
        Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
        Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
        Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800
   A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación que sea capaz de:
        Inscribir a un nuevo participante en una categoría. (Tener en cuenta que cada categoría tiene una lista de inscriptos diferente).
        Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        Desinscribir a un participante de una categoría.
        Determinar el monto que deberá abonar cada participante al inscribirse.
     Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500.
*/

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Inscripto inscripto1 = new Inscripto(37905751,"Sofia", "Monasterio",29, 123, 456, "a+",1 );
        Inscripto inscripto2 = new Inscripto(31254555,"Pablo", "Cuezzo",15, 123, 456, "a+", 2 );
        Inscripto inscripto3 = new Inscripto(31254555,"Lucas", "Cuezzo",16, 123, 456, "a+", 3 );

        Set<Inscripto> inscriptoSet = new HashSet<>();
        inscriptoSet.add(inscripto1);
        inscriptoSet.add(inscripto2);
        inscriptoSet.add(inscripto3);

        for (Inscripto inscripto: inscriptoSet) {
            if (inscripto.circuito == 1) {
                if (inscripto.edad < 18){
                    System.out.println(inscripto.nombre+" es menor de edad (" +inscripto.edad+"), y se inscribió en el Circuito Chico. Debe pagar $1300");
                } else{
                    System.out.println(inscripto.nombre+" es mayor de edad (" +inscripto.edad+"), y se inscribió en el Circuito Chico. Debe pagar $1500");
                }
            } else if (inscripto.circuito == 2) {
                if (inscripto.edad < 18){
                    System.out.println(inscripto.nombre+" es menor de edad (" +inscripto.edad+"), y se inscribió en el Circuito Medio. Debe pagar $2000");
                } else{
                    System.out.println(inscripto.nombre+" es mayor de edad (" +inscripto.edad+"), y se inscribió en el Circuito Medio. Debe pagar $2500");
                }
            }else if (inscripto.circuito == 3 && inscripto.edad>18){
                System.out.println(inscripto.nombre+" es mayor de edad (" +inscripto.edad+"), y se inscribió en el Circuito Avanzado. Debe pagar $2800");
            }else {
                System.out.println("No puede inscribirse en el circuito Avanzado por ser menor de edad.");
            }

        }


    }
}