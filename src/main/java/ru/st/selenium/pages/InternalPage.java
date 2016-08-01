package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {
	private int movieCount;
	private int countSearchElements;
	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath("//nav/div[@id='search']")));
    return this;
  }
  
  @FindBy (css = "h1")
  private WebElement logoLink;
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[href $= '?logout']")
  private WebElement logoutLink;
  
  @FindBy(xpath = "//img[@alt='Add movie']")
  private WebElement addFilmButton;
  
  @FindBy(xpath = "//div[@id='results']/a[1]/div")
  private WebElement firstFilm;
  
  @FindBy(id = "q")
  private WebElement searchField;

  public InternalPage clickLogoLink() {
		 logoLink.click();
		 return pages.internalPage;
	  }
  
  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    return pages.userProfilePage;
  }

  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    return pages.userManagementPage;
  }
  
  public LoginPage clickLogoutLink() {
    logoutLink.click();
    wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }

  private int getMovieCount() {
	  return driver.findElements(By.xpath("//div[@id='results']/a")).size();  
  }
  
  public FilmAddPage clickAddMovieButton() {
	  movieCount = getMovieCount();
	  addFilmButton.click();
	  return pages.filmAddPage;
  }
  
  public boolean isMovieAdded() {
	  this.ensurePageLoaded();
	  boolean result = false;
	  System.out.println("*********** Movies before add = " + movieCount);
	  System.out.println("************ Movies after add = " + getMovieCount());
	  if (movieCount + 1 == getMovieCount())
		  result = true;
	  return result;
  }
  
  public FilmViewPage clickFirstMovie(){
	 movieCount = getMovieCount();  
	 firstFilm.click();
	 return pages.filmViewPage;
  }
  
  public boolean isMovieRemoved() {
	  this.ensurePageLoaded();
	  boolean result = false;
	  System.out.println("*********** Movies before remove = " + movieCount);
	  System.out.println("************ Movies after remove = " + getMovieCount());
	  if (movieCount - 1 == getMovieCount())
		  result = true;
	  return result;
  }
  
  public boolean isEmptyList()  {
	this.ensurePageLoaded();
    try {
        driver.findElement(By.xpath("//div[@id='results']/a[1]/div"));
        return false;
    } 
    catch (NoSuchElementException e) {
        return true;
    }
	   
  }
  
  public InternalPage setSearchField(String text) {
	  	searchField.clear();
	    searchField.sendKeys(text);
	    String xPathQuery = "//div[@id='results']//div[@class='title']"
	    		+ "[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
	    		+ text.toLowerCase() + "')]";
	    countSearchElements = driver.findElements(By.xpath(xPathQuery)).size();
	    searchField.sendKeys(Keys.ENTER);
	    this.ensurePageLoaded();
	    while (getMovieCount() != countSearchElements) {};
	    return this;
	  }
  
  public boolean isSearchFilmOK(){
	  boolean result = true;
  
	  if (countSearchElements != getMovieCount())
		  result = false;
	  return result;
  }
}
