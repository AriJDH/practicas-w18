package ejercicio4_comp_Universidad.Intefaz;

public interface FuncionSoporteTecnico {
    default String darSoporteTecnico(){
        String mensaje = "Doy Sorporte Técnico";
        //System.out.println("Doy Sorporte Técnico");
        return mensaje;
    }
}
