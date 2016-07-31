package ru.st.selenium;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;

public class AddNewMovie extends TestBase{
	
	private static String[] LIST_OF_MOVIE = 
		{"The Green Mile","Forrest Gump","Intouchables","Inception", "Fight Club",
		 "The Lion King","Knockin on Heavens Door","The Prestige","The Godfather","Gladiator"};
	
	private static String[] LIST_OF_MOVIE_YEAR = 
		{"2000", "1999", "2011", "2010", "1999",
		 "1994","1994","2006","1972","2000"};

	@Test
	public void addNewMovieOK() {
	
		Random rand = new Random();
		int numberMovie = rand.nextInt(LIST_OF_MOVIE.length);
		Film film = new Film()
		.setTitle(LIST_OF_MOVIE[numberMovie])
		.setYear(LIST_OF_MOVIE_YEAR[numberMovie]);

		
		app.getUserHelper().loginAs(ADMIN);
		app.getUserHelper().addMovie(user);
		app.getUserHelper().logout();
		//assertTrue(app.getUserHelper().isLoggedInAs(user));
}
