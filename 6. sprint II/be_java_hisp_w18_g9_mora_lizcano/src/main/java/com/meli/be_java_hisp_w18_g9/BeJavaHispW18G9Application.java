package com.meli.be_java_hisp_w18_g9;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IProductRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class BeJavaHispW18G9Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(BeJavaHispW18G9Application.class, args);

        // Test elements

        IProductRepository productRepository = context.getBean(IProductRepository.class);
        IUserRepository userRepository = context.getBean(IUserRepository.class);

        productRepository.save(new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!"));
        productRepository.save(new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!"));
        productRepository.save(new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!"));

        User user1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userRepository.save(user1);
        userRepository.save(user2);

        userRepository.save(new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), productRepository.findAll()));
        userRepository.save(new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), productRepository.findAll()));

    }

}
