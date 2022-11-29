package mercadolibre.bootcamp.ejemplomocks.repository;

import mercadolibre.bootcamp.ejemplomocks.dto.CharacterDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CharacterRepository {
    List<CharacterDTO> characterDTOList = new ArrayList<>();
    public List<CharacterDTO> findAllByNameContains(String query) {
        List<CharacterDTO> result = new ArrayList<>();

        result.add(characterDTOList.stream()
                .filter(x->x.getName().equals(query))
                .findFirst().orElse(null));

        return  result;
    }
}
