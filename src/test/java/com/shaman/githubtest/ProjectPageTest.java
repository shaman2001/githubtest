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
import com.shaman.githubtest.pages.ProjectPage;

public class ProjectPageTest extends PageTest {
	protected ProjectPage projectPage = null;
	private final static String CLONEWNDTITLE = "Clone with SSH";
	
	@BeforeClass
  	public void initPageObjects() {
		this.projectPage = super.homePage.lnkMyProjectClick();
	}
	
	@Parameters({"project-name"})
	@Test(description="Title string of project page",enabled = true)
	public void titleProjectTest(@Optional(value = "task_1") String projectName) {
		
		//System.out.println(this.projectPage.getTitle());
		System.out.println(projectName);
		//Assert.assertEquals(this.projectPage.getTitle().contains(projectName), projectName);
		Assert.assertTrue(this.projectPage.getTitle().contains("task_1"));
	}
	@Test (description="Commits link availability",enabled = true)
	public void commitsLinkTest() {
		Assert.assertTrue(projectPage.isExistLnkCommits());
	}
	@Test (description="Branches link availability",enabled = true)
	public void branchesLinkTest() {
		Assert.assertTrue(projectPage.isExistLnkBranches());
	}
	@Test (description="Releases link availability",enabled = true)
	public void releasesLinkTest() {
		Assert.assertTrue(projectPage.isExistLnkReleases());
	}
	@Test (description="Contributors link availability",enabled = true)
	public void contributorsLinkTest() {
		Assert.assertTrue(projectPage.isExistLnkContributors());
	}
	/*@Test (description="Clone or dowload window header check", priority=1, enabled = true)
	public void cloneWndTitleTest() {
		String titleAct = this.projectPage.getCloneWndTitle();
		Assert.assertEquals(titleAct, CLONEWNDTITLE);
	}*/
	
	@Test (description="Check is Readme label and Readme.md file content equals", priority=2, enabled = true)
	public void readmelblTest() {
		String lblReadme = this.projectPage.getLblReadmeContent();
		this.projectPage.lnkReadmeMDClick();
		String textReadme = this.projectPage.getLblReadmeFileContent();
		Assert.assertEquals(textReadme, lblReadme);
		//System.out.println(textReadme);
	}
	
	
	
	
	
}
