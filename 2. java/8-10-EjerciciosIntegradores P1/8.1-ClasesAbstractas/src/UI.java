import java.util.Scanner;

public class UI {

    private int serieType;
    private PrototypeOne prototypeOne;
    private PrototypeTwo prototypeTwo;

    public UI() {
    }

    public UI(int serieType, PrototypeOne prototypeOne, PrototypeTwo prototypeTwo) {
        this.serieType = serieType;
        this.prototypeOne = prototypeOne;
        this.prototypeTwo = prototypeTwo;
    }

    // Inicia sistema
    public void startSystem() {
        System.out.println(" ----------- (ノ°∀°)ノ⌒･*:.｡. .｡.:*･゜ﾟ･*☆\t Te damos la bienvenida!   -------------- \n" +
                " Elegí qué tipo de serie querés usar: \n" +
                "1- Serie de Doubles\n" +
                "2- Serie de Integers\n" +
                "3- Salir del sistema \n" +
                "A continuación ingresá el número de la opción que elegiste y presioná <<enter>>:");

        Scanner input = new Scanner(System.in);
        int opcionElegida = input.nextInt();

        switch (opcionElegida) {
            case 1:
                startSerieOne();
                showMenu();
                break;
            case 2:
                startSerieTwo();
                showMenu();
                break;
            case 3:
                System.out.println("Saliste del sistema! gracias!! (=^ ◡ ^=)\t ");
                break;
            default:
                System.out.println("La opción elegida no es válida. Ingresá 1 o 2");
                this.startSystem();
                break;
        }
    }

    // Inicia Serie 1
    private void startSerieOne() {
        this.serieType = 1;
        System.out.println("Elegiste la serie Double. \n" +
                "Cuando te pidan ingresar valores, recordá ingresar un número CON decimales" +
                " Ej: 0.00");
        showMenu();
    }

    // Inicia serie 2
    private void startSerieTwo() {
        this.serieType = 2;
        System.out.println("Elegiste la serie Integer. \n" +
                "Cuando te pidan ingresar valores, recordá ingresar un número SIN decimales" +
                " Ej: 0");
        showMenu();
    }

    // Interacción con el usuario
    public void showMenu() {
        System.out.println(" (≧▽≦)/\t  Elegí una opción: \n" +
                "1- Ingresar/modificar primer valor de la serie \n" +
                "2- Ingresar el valor que sumarás a cada número de la serie\n" +
                "3- Mostrar siguiente valor\n" +
                "4- Reiniciar la serie al último valor asignado \n" +
                "5- Volver al menú principal\n" +
                "6- Salir del sistema\n" +
                "Recordá que debes ingresar un número entero del 1 al 5 para elegir tu opción");

        Scanner input = new Scanner(System.in);
        int opcionElegida = input.nextInt();

        switch (opcionElegida) {
            case 1:
                firstValue();
                showMenu();
                break;
            case 2:
                sumValue();
                showMenu();
                break;
            case 3:
                showNextValue();
                showMenu();
                break;
            case 4:
                resetValue();
                showMenu();
                break;
            case 5:
                startSystem();
                showMenu();
                break;
            case 6:
                System.out.println("Saliste del sistema! gracias!! (=^ ◡ ^=)\t ");
                break;
            default:
                System.out.println("La opción elegida no es válida. Ingresá un número del 1 al 4.");
                this.showMenu();
                break;
        }
    }

    // Métodos para cada opción
    /* ---------------- Opción 1 ----------------------- */
    Scanner input = new Scanner(System.in);
    private void firstValue() {
        if (this.serieType == 1) {
            Double newValue1 = input.nextDouble();
            prototypeOne.setInitialValue(newValue1);
        } else if (this.serieType == 2) {
            Integer newValue2 = input.nextInt();
            prototypeTwo.setInitialValue(newValue2);
        }
    }

    /* ---------------- Opción 2 ----------------------- */
    private void sumValue() {
        Scanner input = new Scanner(System.in);
        if (this.serieType == 1) {
            Double a1 = input.nextDouble();
            prototypeOne.setA(a1);
        } else if (this.serieType == 2) {
            Integer a2 = input.nextInt();
            prototypeTwo.setA(a2);
        }

    }

    /* ---------------- Opción 3 ----------------------- */
    private void showNextValue() {
        if (this.serieType == 1) {
            System.out.println(
                    "------------------------------------------------ \n" +
                            " El próximo número es: " + prototypeOne.nextValue(prototypeOne.getA()) +
                            " \n------------------------------------------------ ");
        } else if (this.serieType == 2) {
            System.out.println(
                    "------------------------------------------------ \n" +
                            " El próximo número es: " + prototypeTwo.nextValue(prototypeTwo.getA()) +
                            " \n------------------------------------------------ ");
        }
    }
    /* ---------------- Opción 4 ----------------------- */
    private void resetValue() {
        if (this.serieType == 1) {
            prototypeOne.setValue();
        } else if (this.serieType == 2) {
            prototypeTwo.setValue();
        }
    }
}
