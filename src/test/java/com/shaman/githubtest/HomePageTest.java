package com.shaman.githubtest;

//import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.shaman.githubtest.pages.HomePage;
//import com.shaman.githubtest.pages.LoginPage;
//import com.shaman.githubtest.pages.ProfilePage;
//import com.shaman.githubtest.pages.ProjectPage;

public class HomePageTest extends PageTest {
	private final static String OWNER = "shaman2001";
	
	/*@BeforeClass
  	public void initPageObjects() {
		
	}*/
	
	
	@Test (description="Check ownwer in the new repository page",enabled = true)
	public void commitsLinkTest() {
		logger.info("Start test CommitsLinkTest");
		Assert.assertEquals(super.homePage.getOwnerFromNewRepPage(),OWNER);
	}
	
	@Test (description="Check button-links in repo-filter box",enabled = true)
	public void btnLinkRepoFTest() {
		logger.info("Start test BtnLinkRepoFTest");
		Assert.assertTrue(super.homePage.isExistsBtnsRFltr());
	}
	
	@Test (description="Check search results page title",enabled = true)
	public void searchResPageTest() {
		logger.info("Start test SearchResPageTest");
		Assert.assertTrue(super.homePage.getSearchPageTitle().contains(OWNER));
	}
	
	
	
}
