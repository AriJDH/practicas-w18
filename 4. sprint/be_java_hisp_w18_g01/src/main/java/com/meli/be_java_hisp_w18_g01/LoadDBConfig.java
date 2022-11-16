package com.meli.be_java_hisp_w18_g01;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDBConfig {

    @Autowired
    private UserRepository userRepository;
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(){
        return (args)->{

            User lucas = new User(1L, "lucas");
            Product product1 = new Product(1L, "Zapatillas", "Tipo de zapatilla",
                    "Adadis", "Blancas", "Las mejores zapas del condado");
            Post post1 = new Post(1L, lucas, LocalDate.now(),product1,100, 20000);
            lucas.addPost(post1);

            userRepository.add(lucas);

            User miguel = new User(2L, "miguel");
            userRepository.add(miguel);



            //userRepository.add(user); y asi vamos agregando datos mock a la db en memoria

        };
    }
}
