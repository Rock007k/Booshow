package com.app;

import com.app.entity.Movie;
import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooShowApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooShowApplication.class, args);


	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieService movieService;

	@Override
	public void run(String... args) throws Exception {
		User user = User.builder().name("ayush").build();
		userRepository.save(user);

		movieService.saveMovie(new Movie("Tenet"));
	}
}
