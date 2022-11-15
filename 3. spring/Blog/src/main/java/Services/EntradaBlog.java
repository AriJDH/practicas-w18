package Services;

import Repository.EntradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlog {
    @Autowired
    EntradasRepository entradas;
    int idDisponible = 0;

    public ResponseEntity<EntradaBlog> createNewEntrada(EntradaBlog entrada){
        try{
            if(entradas.getEntradas().containsKey(idDisponible)){
                throw new Exception("Ya existe una entrada de blog con este ID");
            }
            entrada.getId() = idDisponible;
            entradas.getEntradas().put(idDisponible,entrada);
            idDisponible++;
            return new ResponseEntity<>(entrada, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(entrada, HttpStatus.BAD_REQUEST);
        }
    }
}
