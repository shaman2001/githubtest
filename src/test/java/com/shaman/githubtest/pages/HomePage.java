package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends Page {
	private final static String QUERY_BY_USER = "user:shaman2001";
	
	@FindBy(xpath = ".//a[@class='btn btn-sm btn-primary']d")
	private WebElement btnNewRep;
	
	@FindBy(xpath = ".//span[text()='task_1']")
	private WebElement myProjectLink;
	
	@FindBy(xpath = ".//img[@class='avatar']")
	private WebElement ddMenuView;
	
	@FindBy(xpath = ".//a[contains(text(),'Your profile')]")
	private WebElement ddMenuProfile;
	
	@FindBy(xpath = ".//a[contains(@aria-label,'Create new')]")
	private WebElement ddMenuCreate;
	
	@FindBy(xpath = ".//a[contains(text(),'New repository')]")
	private WebElement ddMenuItemNewRep;
	
	@FindBy(xpath = ".//span[text()='shaman2001']")
	private WebElement btnOwner;
	
	@FindBy(xpath = ".//button[@type='button']|text()='All'")
	private WebElement btnLinkAll;
	
	@FindBy(xpath = ".//button[@type='button']|text()='Public'")
	private WebElement btnLinkPublic;
	
	@FindBy(xpath = ".//button[@type='button']|text()='Private'")
	private WebElement btnLinkPrivate;
	
	@FindBy(xpath = ".//button[@type='button']|text()='Sources'")
	private WebElement btnLinkSources;
	
	@FindBy(xpath = ".//button[@type='button']|text()='Forks'")
	private WebElement btnLinkForks;
	
	@FindBy(xpath = ".//input[@name ='q']")
	private WebElement fSearch;
	
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
	
	public String getOwnerFromNewRepPage() {
		ddMenuCreate.click();
		ddMenuItemNewRep.click();
		(new WebDriverWait(super.webDrv,10)).until (new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("Create");
			}
		});
		PageFactory.initElements(this.webDrv, this);
		String result = btnOwner.getText();
		super.webDrv.navigate().back();
		return result;
	}
	
	public boolean isExistsBtnsRFltr() {
		boolean result = this.btnLinkAll!=null && this.btnLinkPublic!=null
				&& btnLinkPrivate!=null && btnLinkSources!=null 
				&& btnLinkForks!=null;
		return result;	
	}
	
	public String getSearchPageTitle() {
		fSearch.sendKeys(QUERY_BY_USER);
		fSearch.submit();
		(new WebDriverWait(super.webDrv,10)).until (new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("Search");
			}
		});
		String result = this.getTitle();
		super.webDrv.navigate().back();
		return result;
	}

}
