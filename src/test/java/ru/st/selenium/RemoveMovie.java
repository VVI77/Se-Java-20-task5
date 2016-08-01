package ru.st.selenium;

import static org.junit.Assert.assertTrue;
import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;

public class RemoveMovie extends TestBase{
	
	@Test
	public void RemoveMovieOK() {
		
		app.getUserHelper().loginAs(ADMIN);
		
		if (app.getFilmHelper().isEmptyFilmList()){
			Film film = new Film()
			.setTitle(MOVIE[1])
			.setYear(MOVIEYEAR[1]);
			app.getFilmHelper().create(film);
		}
		
		app.getFilmHelper().delete();
		assertTrue(app.getFilmHelper().isFilmRemoved());
		
		app.getUserHelper().logout();
	}
}
