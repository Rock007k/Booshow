package com.app;

import com.app.entity.Movie;
import com.app.entity.User;
import com.app.enums.Gender;
import com.app.enums.Genre;
import com.app.enums.Language;
import com.app.repository.MovieRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class BooShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooShowApplication.class, args);


	}

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private MovieRepository movieRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		User user = User.builder()
//				.name("John Doe")
//				.age(30)
//				.address("123 Main Street, Cityville")
//				.gender(Gender.MALE)              // Assuming Gender is an enum and MALE is a valid value
//				.mobileNo("1234567890")
//				.emailId("johndoe@example.com")
//				.password("securePassword123")    // Use appropriate encryption/hashing for production environments
//				.roles("USER")                    // Assuming roles are stored as a String, this could also be an enum
//				.build();
//
//		userRepository.save(user);
//		Movie movie = Movie.builder()
//				.movieName("Inception")
//				.duration(148)
//				.rating(8.8)
//				.releaseDate(Date.valueOf("2010-07-16"))  // Assuming you are using java.sql.Date
//				.genre(Genre.THRILLER)                      // Assuming Genre is an enum and SCI_FI is a valid value
//				.language(Language.ENGLISH)               // Assuming Language is an enum and ENGLISH is a valid value
//				.build();
//
//		movieRepository.save(movie);
//	}
}
