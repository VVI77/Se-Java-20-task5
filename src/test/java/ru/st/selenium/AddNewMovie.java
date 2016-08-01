package ru.st.selenium;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import org.testng.annotations.Test;
import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;

public class AddNewMovie extends TestBase{

	@Test
	public void addNewMovieOK() {
		
		app.getUserHelper().loginAs(ADMIN);
		
		Random rand = new Random();
		int pos = rand.nextInt(MOVIE.length);
		Film film = new Film()
		.setTitle(MOVIE[pos])
		.setYear(MOVIEYEAR[pos]);
		app.getFilmHelper().create(film);
		assertTrue(app.getFilmHelper().isFilmCreated());
		
		app.getUserHelper().logout();
	}
}
