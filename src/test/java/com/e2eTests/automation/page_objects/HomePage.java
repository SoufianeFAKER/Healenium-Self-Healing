package com.e2eTests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.BasePage;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.Setup;

public class HomePage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Home']")
	private static WebElement btnHome;
	
	@FindBy(how = How.CSS, using = ".fa.fa-lock")
	private static WebElement btnSignupLogin;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Contact us']")
	private static WebElement btnContactUs;
	
	public SeleniumUtils seleniumUtils;

	public HomePage() {
		
		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
		
	}
	
	public String getAttributeOfElement() {

		return btnHome.getAttribute("style");

	}
	
	public void clicksOnBtnHome() {
		
		seleniumUtils.click(btnHome);
		
	}
	
	public void clickOnBtnSignupLogin() {

		seleniumUtils.click(btnSignupLogin);

	}
	
	public void clickOnBtnContactUs() {
		
		seleniumUtils.click(btnContactUs);
		
	}

}
