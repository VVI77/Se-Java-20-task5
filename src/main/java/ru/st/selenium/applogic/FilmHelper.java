package ru.st.selenium.applogic;

import ru.st.selenium.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete();
	void search(String title);
	boolean isFilmCreated();
	boolean isFilmRemoved();
	boolean isEmptyFilmList();
	boolean isSearchOK();
}
