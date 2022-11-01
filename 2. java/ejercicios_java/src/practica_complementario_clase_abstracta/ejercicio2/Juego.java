package practica_complementario_clase_abstracta.ejercicio2;

import java.util.List;

public class Juego {

    private List<Asteroide> coordenadasAsteroides;

    private List<Participante> participantes;

    public void empezarJuego() {

        int indiceParticipanteGanadorPunto = 0;

        double distanciaMasCercana = 0.0;

        //Recorrer por cada asteroide para revisar que nave esta mas cerca en esa ubicacion
        for (Asteroide asteroide : coordenadasAsteroides) {

            //Se recorre cada participante
            for (int i = 0; i < participantes.size(); i++) {

                //Se obtiene al participante
                Participante participante = participantes.get(i);

                //Por cada participante se empezara el juego que es identificar la distancia mas cercana
                //que tenga con sus naves o flotas
                double distanciaMasCercanaP = participante.empezarJuego(asteroide.getX(), asteroide.getY());

                //En la primera iteracion se asignara una distancia para tener un inicio
                if (i == 0) {
                    distanciaMasCercana = distanciaMasCercanaP;
                }

                //Si la distancia iterada es mas cercana que la final se asigna y se identifica el indice
                //del participante asociado a esa distancia
                if (distanciaMasCercanaP < distanciaMasCercana) {
                    distanciaMasCercana = distanciaMasCercanaP;
                    indiceParticipanteGanadorPunto = i;
                }
            }

            //Se suma un punta al participante con la distancia mas cercana del asteroide que se esta
            //iterando
            participantes.get(indiceParticipanteGanadorPunto).sumarPunto();
        }

        this.imprimirParticipanteGanador(participantes);
    }

    private void imprimirParticipanteGanador(List<Participante> participantes) {

        System.out.println(" ====== Todos los participantes =======");
        participantes.stream().forEach(System.out::println);

        System.out.println("===== GANADOR =========");
        Participante participante = participantes.stream()
                .max((x1, x2) -> x1.getPuntuacion().compareTo(x2.getPuntuacion())).get();

        System.out.println(participante);
    }

    public List<Asteroide> getCoordenadasAsteroides() {
        return coordenadasAsteroides;
    }

    public void setCoordenadasAsteroides(List<Asteroide> coordenadasAsteroides) {
        this.coordenadasAsteroides = coordenadasAsteroides;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}
