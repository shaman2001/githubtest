package com.shaman.githubtest;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.shaman.githubtest.pages.HomePage;
//import com.shaman.githubtest.pages.LoginPage;
import com.shaman.githubtest.pages.ProjSettingsPage;
//import com.shaman.githubtest.pages.ProjectPage;

public class ProjSettingsPageTest extends PageTest {
	//protected ProjectPage projectPage = null;
	protected ProjSettingsPage projsettingsPage = null;
	
	@BeforeClass
  	public void initPageObjects() throws InterruptedException {
		projsettingsPage = super.homePage.lnkMyProjectClick().tabSettingsClick();
		(new WebDriverWait(this.driver,5)).until (new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("options");
			}
		});
  	}
	
	
	@Test (description="Check project name on settings Page",enabled = true)
	public void projectNameTest() {
		Assert.assertEquals(projsettingsPage.getProjName(), "task_1");
	}
	@AfterClass
	public void homePageBack () {
		this.projsettingsPage.codeTabClick();
		System.out.println("CodeTab clicked");
	}
}
