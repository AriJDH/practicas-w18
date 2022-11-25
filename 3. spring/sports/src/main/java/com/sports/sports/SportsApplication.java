package com.sports.sports;

import com.sports.sports.entities.Sport;
import com.sports.sports.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class SportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
		ArrayList<Sport> sports = new ArrayList<>();
		Sport tennis = new Sport("Tennis", "easy");
		Sport rugby = new Sport("Rugby", "easy");
		Sport football = new Sport("Footbal", "easy");

		Sport.saveSport(tennis);
		Sport.saveSport(rugby);
		Sport.saveSport(football);

		sports.add(tennis);
		sports.add(rugby);
		sports.add(football);

		User user1 = new User("Lucas", "Padula", 24, sports);
	}

}
