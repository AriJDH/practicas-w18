package repository;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlatoRepository implements IRepository {

    private List<Food> foods;

    private List<Plato> platos;

    public PlatoRepository() {
        loadList();
        crearPlatos();
    }

    @Override
    public Plato consultarPlato(String nombre, Integer peso) {
        return platos.stream().filter(x -> x.getNombre().equals(nombre) && x.getPesoGramo().equals(peso)).findAny().orElse(null);
    }

    private void loadList() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Food>> typeRef = new TypeReference<>(){};
        try {
            foods = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearPlatos() {

        List<Food> ingredientesMilanesa = Arrays.asList(foods.get(0), foods.get(1));

        Integer sumatoriaIngredientes = ingredientesMilanesa.stream().map(x -> x.getCalories()).reduce(0, (a, b) -> a + b);

        platos = Arrays.asList(new Plato("Milanesa", ingredientesMilanesa, sumatoriaIngredientes),
                new Plato("Champiniones", ingredientesMilanesa, sumatoriaIngredientes));
    }
}