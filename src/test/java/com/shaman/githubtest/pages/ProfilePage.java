package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage extends Page {
	
	@FindBy(xpath = ".//a[contains(@href,'mailto')]")
	private WebElement lnkOwnerEmail;
	
	@FindBy(xpath = ".//a[@class='btn btn-sm']")
	private WebElement btnEditProfile;
	
	

	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	public ProfilePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDrv, this);
	}
			
	public String getProfileEMail() {
		return this.lnkOwnerEmail.getText();
	}
	
  
}
