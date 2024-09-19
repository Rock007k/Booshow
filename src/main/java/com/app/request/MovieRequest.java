package com.app.request;

import java.util.Date;

import com.app.enums.Genre;
import com.app.enums.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

	private String movieName;
	private Integer duration;
	private double rating;
	private Date releaseDate;
	private Genre genre;
	private Language language;
}
