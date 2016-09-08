package com.shaman.githubtest.pages;


//import ru.stqa.selenium.factory.WebDriverFactory;
//import ru.stqa.selenium.factory.WebDriverFactoryMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends Page {
	
	@FindBy(name = "login")
	private WebElement fUserName; 
	@FindBy(name = "password")
	private WebElement fUserPass;
	

	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDrv, this);
	}
  
	public HomePage login (String username, String password) {
		fUserName.clear();
		fUserName.sendKeys(username);
		fUserPass.clear();
		fUserPass.sendKeys(password);
		fUserPass.submit();
		return new HomePage(this.webDrv);
	}
	
	
  
}
