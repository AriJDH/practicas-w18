package Controllers;

import Entity.EntradaBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class EntradaBlogController {

    @PostMapping("/blog")
    public EntradaBlog createBlog(@RequestBody EntradaBlog entrada){
        if (entrada.id){
            throw new UniqueException("La id ya se encuentra en uso");
        return ;

    }
}
