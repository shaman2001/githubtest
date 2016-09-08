package com.shaman.githubtest;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.shaman.githubtest.pages.HomePage;
import com.shaman.githubtest.pages.LoginPage;
import com.shaman.githubtest.pages.ProfilePage;
import com.shaman.githubtest.pages.ProjectPage;

public class ProfilePageTest extends PageTest {
	private final static String EMAIL = "v.s.kotovich@gmail.com";
	protected ProfilePage profilePage = null;
	
	@BeforeClass
  	public void initPageObjects() {
		this.profilePage = super.homePage.ddMenuProfileClick();
	}
	
	
	@Test (description="Check e-mail of the profile",enabled = true)
	public void commitsLinkTest() {
		Assert.assertEquals(profilePage.getProfileEMail(),EMAIL);
	}
	
	
	
	
	
}
