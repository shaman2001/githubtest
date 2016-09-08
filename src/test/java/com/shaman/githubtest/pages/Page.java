package com.shaman.githubtest.pages;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver webDrv;

  
  public Page(WebDriver driver) {
    this.webDrv = driver;
  }

  public String getTitle() {
    return webDrv.getTitle();
  }

}
