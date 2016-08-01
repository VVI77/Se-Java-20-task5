package ru.st.selenium.pages;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
	
public class FilmViewPage extends InternalPage {
		
		public FilmViewPage(PageManager pages) {
			super(pages);
		}
	    
		  @FindBy (xpath = "//img[@alt='Edit']")
		  private WebElement editButton;
		
		  @FindBy (xpath = "//img[@alt='Remove']")
		  private WebElement removeButton;
		  
		  @FindBy (xpath = "//img[@alt='Own']")
		  private WebElement ownButton;
		
		  @FindBy (xpath = "//img[@alt='Seen']")
		  private WebElement seenButton;
		  
  
	  public FilmViewPage clickEditButton() {
		 editButton.click();
		 return this;
	  }

	  public FilmViewPage clickRemoveButton() {
		 removeButton.click();
		 wait.until(alertIsPresent()).accept();
		 return this;
	  }
	  
	  public FilmViewPage clickOwnButton() {
		 ownButton.click();
		 return this;
	  }

	  public FilmViewPage clickSeenButton() {
		 seenButton.click();
		 return this;
	  }  

	  public FilmViewPage ensurePageLoaded() {
	    wait.until(presenceOfElementLocated(By.xpath("//img[@alt='Remove']")));
	    return this;
	  }

}

