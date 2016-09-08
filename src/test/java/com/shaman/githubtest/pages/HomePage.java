package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page {
	
	@FindBy(xpath = ".//a[@class='btn btn-sm btn-primary']d")
	private WebElement btnNewRep;
	
	@FindBy(xpath = ".//span[text()='task_1']")
	private WebElement myProjectLink;
	
	@FindBy(xpath = ".//img[@class='avatar']")
	private WebElement ddMenuView;
	
	@FindBy(xpath = ".//a[contains(text(),'Your profile')]")
	private WebElement ddMenuProfile;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDrv, this);
	}
	
	public void btnNewRepClick() {
		btnNewRep.click();
	}
	
	public ProjectPage lnkMyProjectClick() {
		myProjectLink.click();
		return new ProjectPage(this.webDrv);
	}
	
	public ProfilePage ddMenuProfileClick() {
		ddMenuView.click();
		ddMenuProfile.click();
		return new ProfilePage(this.webDrv);
	}
  
}
