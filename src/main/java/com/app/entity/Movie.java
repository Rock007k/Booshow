package com.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.app.enums.Genre;
import com.app.enums.Language;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "MOVIES")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String movieName;

	public Movie(String movieName) {
		this.movieName =movieName;
	}

	private Integer duration;

	@Column(scale =2)
	private Double rating;
	
	
	private Date releaseDate;

	@Enumerated(value = EnumType.STRING)
	private Genre genre;

	@Enumerated(value = EnumType.STRING)
	private Language language;
	
	@OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
	private List<Show> shows = new ArrayList<>();
	
}
