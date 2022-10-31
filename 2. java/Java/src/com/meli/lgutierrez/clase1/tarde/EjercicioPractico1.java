package com.meli.lgutierrez.clase1.tarde;

public class EjercicioPractico1 {

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 21000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularAumento() {

            // Tu codigo aqui
            if (sueldoBase <= 20000) {
                sueldoConAumento = sueldoBase + sueldoBase*0.2;
            }
              else {
                if (sueldoBase > 20000 && sueldoBase <= 45000){
                  sueldoConAumento = sueldoBase + sueldoBase*0.1;
                }
                else {
                    sueldoConAumento = sueldoBase + sueldoBase*0.05;
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }

        public static void main(String[] args) {
            EjercicioPractico1 prueba = new EjercicioPractico1();
            prueba.calcularAumento();
        }

    }

