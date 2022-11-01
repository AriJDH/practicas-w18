import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Object> persona1 = crearPersona("Daniel", "Cagliari", 123456, 20,
                "+54654564", "+546891156", "+O");

        Map<String, Object> persona2 = crearPersona("Richard", "Lambda", 123457, 43,
                "+54654564", "+546891156", "+O");

        Map<String, Object> circuitoChico = crearCategoria("Chico", "2km por selva y arroyos",
                false, 1300, 1500);

        Map<String, Object> circuitoMedio = crearCategoria("Medio", "5km por selva, arroyos y barro",
                false, 2000, 2300);

        Map<String, Object> circuitoMayor = crearCategoria("Mayor",
                "10km por selva, arroyos, barro y escalada en piedra",
                true, 0, 1500);



    }

    public static void mostrarCategorias(String categoria) {

    }

    public static void inscribir(Map<String, Object> categoria, Map<String, Object> persona) {
        ArrayList<Object> listaInscriptos = ( ArrayList<Object> ) categoria.get("inscriptos");
        if ((Integer)persona.get("edad") < 18)


    }

    public static Map<String, Object> crearCategoria(String nombre, String recorrido,
                                                     Boolean soloMayores, Integer precioInscripcionMenor,
                                                     Integer precioInscripcionMayor){

        Map<String, Object> categoria = new HashMap<String, Object>();
        categoria.put("nombre", nombre);
        categoria.put("recorrido", recorrido);
        categoria.put("soloMayor", soloMayores);
        categoria.put("precio_inscripcion_menor", precioInscripcionMenor);
        categoria.put("precio_inscripcion_mayor", precioInscripcionMayor);
        categoria.put("inscriptos", new ArrayList<Object>());

        return categoria;
    }


    public static Map<String, Object> crearPersona(String nombre, String apellido, Integer DNI,
                                                   Integer edad, String celular, String numeroEmergencia,
                                                   String grupoSanguineo) {

        Map<String, Object> persona = new HashMap<>();
        persona.put("nombre", nombre);
        persona.put("apellido", apellido);
        persona.put("DNI", DNI);
        persona.put("edad", edad);
        persona.put("celular", celular);
        persona.put("numeroEmergencia", numeroEmergencia);
        persona.put("grupoSanguineo", grupoSanguineo);

        return persona;
    }



}
