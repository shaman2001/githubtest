package com.shaman.githubtest;


import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageTest extends PageTest {
	private final static String OWNER = "shaman2001";
	
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

	@Test (description="Check repositories quantity",enabled = true)
	public void repoQtyTest() {
		logger.info("Start test repoQtyTest");
		Integer qtyFromList = super.homePage.getRepoQtyFromList() ;
		Integer qtyFromCounter = super.homePage.getRepoQtyFromCounter();
		logger.info("Quantity of repositories on counter = " + qtyFromList);
		logger.info("Quantity of repositories in list = " + qtyFromCounter);
		Assert.assertEquals(qtyFromList, qtyFromCounter);
	}
	
	
}
