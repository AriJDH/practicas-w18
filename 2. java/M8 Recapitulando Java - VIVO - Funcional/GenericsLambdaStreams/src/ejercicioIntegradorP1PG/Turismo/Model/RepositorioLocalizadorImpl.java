package ejercicioIntegradorP1PG.Turismo.Model;


import ejercicioIntegradorP1PG.Turismo.Interfaz.IRepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadorImpl implements IRepositorioLocalizador {

        private List<Localizador> localizador = new ArrayList<>();

        @Override
        public void almacenarLocalizador(Localizador localizadores) {
            getLocalizador().add(localizadores);

        }

        @Override
        public void imprimirLocalizadorGenerado(Localizador localizador) {

            System.out.println(localizador.toString());

        }

        @Override
        public int descuentoPorCliente(Cliente cliente) {

            int cantidadLocalizador = (int) getLocalizador().stream().filter(l -> l.getCliente().equals(cliente))
                    .count();

            return cantidadLocalizador;

        }

        @Override
        public void agregarCliente(Cliente cliente) {
            // TODO Auto-generated method stub

        }

        public List<Localizador> getLocalizador() {
            return localizador;
        }

        public void setLocalizador(List<Localizador> localizador) {
            this.localizador = localizador;
        }



    }

