package com.app.request;


import com.app.enums.Genre;
import com.app.enums.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

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
