package com.e2eTests.automation.step_definitions;

import org.junit.Assert;

import com.e2eTests.automation.page_objects.LoginPage;
import com.e2eTests.automation.page_objects.LogoutPage;

import io.cucumber.java.en.*;

public class LogoutStepDefinition {
	
	public LogoutPage logoutPage = new LogoutPage();
	public LoginPage loginPage = new LoginPage();
	
	@And("User clicks on Logout button")
	public void userClicksOnLogoutButton() {
		
		logoutPage.clickOnBtnLogout();
	    
	}

	@Then("User verify that user is navigated to login page")
	public void userVerifyThatUserIsNavigatedToLoginPage() {
		
		String expectedURL = "https://automationexercise.com/login";
		String actualURL = loginPage.getLoginPageUrl();
		Assert.assertEquals(expectedURL, actualURL);
	    
	}




}
