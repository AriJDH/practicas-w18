public class AumentoSueldo {

        String dni = "12345678"; // dni de ejemplo
        double sueldoBase = 45000; // monto de ejemplo
        double sueldoConAumento;

        public void calcularAumento() {

            // Tu codigo aqui
            if (sueldoBase<=20000) {
                sueldoConAumento = sueldoBase*1.2;
            }
            else {
                if (sueldoBase<=45000){
                    sueldoConAumento = sueldoBase *1.1;
                }
                else {
                    sueldoConAumento = sueldoBase *1.05;
                }
            }

            System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        }

        public static void main(String[] args) {
            new AumentoSueldo().calcularAumento();
        }


}
