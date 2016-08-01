package ru.st.selenium.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import ru.st.selenium.applogic.ApplicationManager;
import ru.st.selenium.applogic2.ApplicationManager2;
import ru.st.selenium.model.User;

public class TestBase {

	public static User ADMIN = new User().setLogin("admin").setPassword("admin");
	
	public static String[] MOVIE =  
	{"The Green Mile","Forrest Gump","Intouchables","Inception", "Fight Club",
	 "The Lion King","Knockin on Heavens Door","The Prestige","The Godfather","Gladiator"};
	
	public static String[] MOVIEYEAR = 
	{"2000", "1999", "2011", "2010", "1999", "1994", "1994", "2006", "1972", "2000"};	
	
	
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}

}
