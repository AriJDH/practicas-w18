package Repository;

import Entity.EntradaBlog;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Data
public class EntradasRepository {
    HashMap<Integer, EntradaBlog> entradas;
}
