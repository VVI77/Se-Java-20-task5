package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmAddPage extends InternalPage {
	
	public FilmAddPage(PageManager pages) {
		super(pages);
	}
	
	  @FindBy (name = "imdbid")
	  private WebElement imdbidField;
	
	  @FindBy(name = "name")
	  private WebElement nameFilmField;
	  
	  @FindBy(name = "year")
	  private WebElement yearField;
	  
	  @FindBy(name = "notes")
	  private WebElement notesField;
	  
	  @FindBy(name = "submit")
	  private WebElement submitButton;
	  
  
  public String getFilmName() {
    return nameFilmField.getAttribute("value");
  }

  public FilmAddPage setFilmName(String text) {
	nameFilmField.sendKeys(text);
    return this;
  }

  public String getYear() {
    return yearField.getAttribute("value");
  }

  public FilmAddPage setYearField(String text) {
    yearField.sendKeys(text);
    return this;
  }
  
  public String getImdBid() {
	return imdbidField.getAttribute("value");
  }

  public FilmAddPage setImdbid(String text) {
    imdbidField.sendKeys(text);
    return this;
  }

  public String getNotes() {
	return notesField.getAttribute("value");
  }

  public FilmAddPage setNotes(String text) {
    notesField.sendKeys(text);
    return this;
  }
  
  public FilmViewPage clickSubmitButton() {
	 submitButton.click();
	 return pages.filmViewPage;
  }

  public FilmAddPage ensurePageLoaded() {
    wait.until(presenceOfElementLocated(By.xpath("//img[@alt='Save']")));
    return this;
  }

}