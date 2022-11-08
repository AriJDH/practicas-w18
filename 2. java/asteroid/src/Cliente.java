import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        Componente participanteA = new Participante();
        Componente participanteB = new Participante();

        Componente naveA = new Nave("A",2,2);
        Componente naveB = new Nave("B",4,4);
        Componente naveC = new Nave("C",6,6);
        Componente naveD = new Nave("D",8,8);

        participanteA.add(naveA);

        participanteB.add(naveB);
        participanteB.add(naveC);
        participanteB.add(naveD);

        List<Componente> participantes = new ArrayList<>();
        participantes.add(participanteA);
        participantes.add(participanteB);

        System.out.println(participanteA.getDistancia());
        System.out.println(participanteB.getDistancia());

    }
}
