public class Main {
    public static void main(String[] args) {
        TemperaturasGlobales temperaturasGlobales= new TemperaturasGlobales();

        temperaturasGlobales.inicializar();
        int menorTemp=temperaturasGlobales.buscarMenorTemperatura();
        int mayorTemp=temperaturasGlobales.buscarMayorTemperatura();

        System.out.println("La ciudad con menor temperatura es: "+ temperaturasGlobales.getCiudadMenorTemperatura()+
                " con "+menorTemp+" grados.");
        System.out.println("La ciudad con mayor temperatura es: "+ temperaturasGlobales.getCiudadMayorTemperatura()+
                " con "+mayorTemp+" grados.");
    }
}