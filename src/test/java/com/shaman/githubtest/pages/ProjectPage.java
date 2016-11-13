package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectPage extends Page {
	
	@FindBy(xpath = ".//a[@class='js-selected-navigation-item reponav-item'][contains(@href, 'settings')]")
	private WebElement tabSettings;
	
	@FindBy(xpath = ".//a[contains(@href, 'commits')]")
	private WebElement lnkCommits;	
	
	@FindBy(xpath = ".//a[contains(@href, 'branches')]")
	private WebElement lnkBranches;	
	
	@FindBy(xpath = ".//a[contains(@href, 'releases')]")
	private WebElement lnkReleases;	
	
	@FindBy(xpath = ".//a[contains(@href, 'contributors')]")
	private WebElement lnkContributors;
	
	@FindBy(xpath = ".//article[contains(@class,'entry-content')]/descendant::p")
	private WebElement lblReadmeContent;
	
	@FindBy(xpath = ".//a[@title='README.md']")
	private WebElement lnkReadmeMD;
	
	@FindBy(xpath = ".//div[@class='file']/descendant::p")
	private WebElement lblReadmeFileContent;
	
	@FindBy(xpath = ".//span[text()='Clone or download']")
	private WebElement btnClone;
	
	@FindBy(xpath = ".//div[@class='clone-options ssh-clone-options']/h4[@class='mb-1']")
	private WebElement lblCloneMenuWnd;

	@FindBy(xpath =".//span[@class='repository-meta-content']")
	private WebElement lblRepoMetaContent;

	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	public ProjectPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(this.webDrv, this);
	}
	
	public ProjSettingsPage tabSettingsClick() {
		tabSettings.click();
		return new ProjSettingsPage(this.webDrv);
	}
	
	public boolean isExistLnkCommits() {
		return this.lnkCommits!=null;
	}
	public boolean isExistLnkBranches() {
		return this.lnkBranches!=null;
	}
	public boolean isExistLnkReleases() {
		return this.lnkReleases!=null;
	}
	public boolean isExistLnkContributors() {
		return this.lnkContributors!=null;
	}
	public String getLblReadmeContent() {
		return this.lblReadmeContent.getText();
	}
	public void lnkReadmeMDClick() {
		lnkReadmeMD.click();
		(new WebDriverWait(super.webDrv,10)).until (new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().contains("README");
			}
		});
		PageFactory.initElements(this.webDrv, this);
	}
	public String getLblReadmeFileContent() {
		return this.lblReadmeFileContent.getText();
	}
	
	public String getCloneWndTitle() {
		btnClone.click();
		String str = this.lblCloneMenuWnd.getText();
		//lblReadmeContent.click();
		//new Actions(this.webDrv).moveToElement(lblRepoMetaContent).build().perform();
		new Actions(this.webDrv).moveByOffset(-200,-200).click().build().perform();
		return str;
	}
	
	public String getBranchesPageTitle() {
		lnkBranches.click();
		
		(new WebDriverWait(super.webDrv,10)).until (new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("Branches");
			}
		});
		String result = this.getTitle();
		super.webDrv.navigate().back();
		return result;
	}
}
