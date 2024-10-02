package com.app.entity;

import java.util.ArrayList;

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
	
	private int duration;
	
	@Column(scale =2)
	private double rating;
	
	
	private date releaseDate;
	
	@Enumerated(value = EnumType.STRING)
	private Genre genre;

	@Enumerated(value = EnumType.STRING)
	private Landuage language;
	
	@OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
	private List<Show> shows = new ArrayList()<>();
	
}
