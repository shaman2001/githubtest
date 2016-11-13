package com.shaman.githubtest;

//import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.shaman.githubtest.pages.ProjectPage;

public class ProjectPageTest extends PageTest {
	protected ProjectPage projectPage = null;
	private final static String CLONEWNDTITLE = "Clone with SSH";
	private final static String BRANCHES_PAGE_TITLE = "Branches · shaman2001/task_1";
	
	@BeforeClass
  	public void initPageObjects() {
		projectPage = super.homePage.lnkMyProjectClick();
	}
	
	@Parameters({"project-name"})
	@Test(description="Title string of project page",enabled = true)
	public void titleProjectTest(@Optional(value = "task_1") String projectName) {
		logger.info("Start test TitleProjectTest");
		logger.debug("Set project name to " + projectName);
		//Assert.assertEquals(this.projectPage.getTitle().contains(projectName), projectName);
		Assert.assertTrue(this.projectPage.getTitle().contains("task_1"));
	}
	@Test (description="Commits link availability",enabled = true)
	public void commitsLinkTest() {
		logger.info("Start test BranchesLinkTest");
		Assert.assertTrue(projectPage.isExistLnkCommits());
	}
	@Test (description="Branches link availability",enabled = true)
	public void branchesLinkTest() {
		logger.info("Start test BranchesLinkTest");
		Assert.assertTrue(projectPage.isExistLnkBranches());
	}
	@Test (description="Releases link availability",enabled = true)
	public void releasesLinkTest() {
		logger.info("Start test ReleasesLinkTest");
		Assert.assertTrue(projectPage.isExistLnkReleases());
	}
	@Test (description="Contributors link availability",enabled = true)
	public void contributorsLinkTest() {
		logger.info("Start test ContributorsLinkTest");
		Assert.assertTrue(projectPage.isExistLnkContributors());
	}
	@Test (description="Clone or download window header check", /*priority=1,*/ enabled = true)
	public void cloneWndTitleTest() {
		String titleAct = this.projectPage.getCloneWndTitle();
		Assert.assertEquals(titleAct, CLONEWNDTITLE);
	}
	
	@Test (description="Check is Readme label and Readme.md file content equals", priority=2, enabled = true)
	public void readmelblTest() {
		logger.info("Start test ReadmelblTest");
		String lblReadme = projectPage.getLblReadmeContent();
		logger.debug("Expected text is " + lblReadme);
		this.projectPage.lnkReadmeMDClick();
		String textReadme = projectPage.getLblReadmeFileContent();
		logger.debug("Actial text is " + textReadme);
		Assert.assertEquals(textReadme, lblReadme);
	}
	@Test (description="Check BranchesPage title", enabled = true)
	public void branchesPageTitleTest() {
		logger.info("Start test BranchesPageTitleTest");
		String resultStr= projectPage.getBranchesPageTitle();
		logger.debug("Expected title is " + BRANCHES_PAGE_TITLE);
		logger.debug("Actial title is " + resultStr);
		Assert.assertEquals(resultStr, BRANCHES_PAGE_TITLE);
	}
	
	
	
}
