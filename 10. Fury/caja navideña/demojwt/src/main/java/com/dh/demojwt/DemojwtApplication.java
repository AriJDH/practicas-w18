package com.dh.demojwt;

import com.dh.demojwt.model.Rol;
import com.dh.demojwt.model.RolE;
import com.dh.demojwt.model.User;
import com.dh.demojwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemojwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojwtApplication.class, args);
	}

	/* */
/*	@Bean
	public CommandLineRunner initData(UserRepository repo) {
		return (args) -> {

			List<Rol> roles = new ArrayList<>();
			Rol admin = new Rol();
			admin.setRol(RolE.ADMIN);
			Rol buyer = new Rol();
			buyer.setRol(RolE.BUYER);
			Rol seller = new Rol();
			seller.setRol(RolE.SELLER);
			roles.add(admin);
			roles.add(seller);
			*//*roles.add(buyer);*//*
			User jack = new User(1, "a", "123", roles);

			repo.save(jack);
		};
	}*/
}
