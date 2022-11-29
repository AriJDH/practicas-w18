package mercadolibre.bootcamp.ejemplomocks.service;

import mercadolibre.bootcamp.ejemplomocks.dto.CharacterDTO;
import mercadolibre.bootcamp.ejemplomocks.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindService {
    private final CharacterRepository characterRepository;

    public FindService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> find(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
