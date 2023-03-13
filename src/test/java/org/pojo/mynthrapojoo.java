package org.pojo;

import org.base.Baseclassss;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mynthrapojoo extends Baseclassss{
	
	public mynthrapojoo() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//input[@class='desktop-searchBar']")
private WebElement searchbox;

@FindBy(xpath = "//a[@class='desktop-submit']")
private WebElement searchbtn;

public WebElement getSearchbox() {
	return searchbox;
}

public WebElement getSearchbtn() {
	return searchbtn;
}



}