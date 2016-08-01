package ru.st.selenium.applogic2;

import java.util.List;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {
	
	
  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub
		pages.internalPage
		.ensurePageLoaded()
		.clickAddMovieButton();
		pages.filmAddPage
		.ensurePageLoaded()
		.setFilmName(film.getTitle())
		.setImdbid(film.getImdb())
		.setYearField(film.getYear())
		.setNotes(film.getNotes())
		.clickSubmitButton();
		pages.filmViewPage
		.ensurePageLoaded()
		.clickLogoLink();
		pages.internalPage
		.ensurePageLoaded();
  }

 public boolean isFilmCreated(){
	 return pages.internalPage.isMovieAdded();
 }
  
  @Override
  public void delete() {
		pages.internalPage
		.ensurePageLoaded()
		.clickFirstMovie();
		
		pages.filmViewPage
		.ensurePageLoaded()		
		.clickRemoveButton();
		
  }
  
  public boolean isFilmRemoved(){
	return pages.internalPage.isMovieRemoved();
	 } 
  
  public boolean isEmptyFilmList(){
	  return pages.internalPage.isEmptyList();
  }

  @Override
  public void search(String title) {
		pages.internalPage
		.ensurePageLoaded()
		.setSearchField(title);
  }
  
  public boolean isSearchOK(){
	  return pages.internalPage.isSearchFilmOK();
	  
  }
  
}
