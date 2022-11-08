public class Estruc3 {
    public static void main(String[] args) {
        int tipoResult = 1;
        String mensaje;
        switch (tipoResult){
            case 1: mensaje = "Aprobado";
            break;
            default: mensaje = "Default";
            break;
        }
        System.out.println(mensaje);
    }
}
