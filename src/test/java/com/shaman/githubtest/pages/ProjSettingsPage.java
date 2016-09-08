package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProjSettingsPage extends Page {
	
	@FindBy(xpath = ".//*[@id='rename_field']")
	private WebElement fRename;
	
	@FindBy(xpath = ".//a[@class='js-selected-navigation-item reponav-item']/span[text()='Code']")
	private WebElement tabCode;

	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	public ProjSettingsPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDrv, this);
	}
			
	public String getProjName() {
		return this.fRename.getAttribute("value");
	}
	public void codeTabClick() {
		tabCode.click();
	}
  
}
