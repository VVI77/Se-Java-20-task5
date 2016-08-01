package ru.st.selenium;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import ru.st.selenium.model.Film;
import ru.st.selenium.pages.TestBase;

public class SearchMovie extends TestBase {
	
	@Test
	public void searchMovieOK() {
		
		String searchWord = "in";
		
		app.getUserHelper().loginAs(ADMIN);
		
		if (app.getFilmHelper().isEmptyFilmList()){
			for (int i=4; i<8; i++) {
				Film film = new Film()
				.setTitle(MOVIE[i])
				.setYear(MOVIEYEAR[i]);
				app.getFilmHelper().create(film);
			}
		}
			
		app.getFilmHelper().search(searchWord);
		assertTrue(app.getFilmHelper().isSearchOK());
		System.out.println("***************** Search work correct!");
		
		searchWord = "";
		app.getFilmHelper().search(searchWord);
		
		while (!app.getFilmHelper().isEmptyFilmList())
			app.getFilmHelper().delete();
		
		app.getUserHelper().logout();
	}

}
