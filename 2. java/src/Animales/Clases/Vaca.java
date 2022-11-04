package Animales.Clases;

import Animales.Interfaces.Herbiboro;

    public class Vaca extends Animal implements Herbiboro {
        public Vaca() {
        }

        @Override
        void sonido() {
            System.out.println("La vaca hace MUUUU");
        }
        @Override
        public void comerHierba() {
            System.out.println("La vaca come hierba");

        }
    }


