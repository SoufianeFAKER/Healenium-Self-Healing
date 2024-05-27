package com.e2eTests.automation.step_definitions;

import org.junit.Assert;

import com.e2eTests.automation.page_objects.LoginPage;

import io.cucumber.java.en.Then;

public class LonginInvalidCredentialsStepDefinition {
	
	public LoginPage loginPage = new LoginPage(); 

	@Then("User verify login error message {string} is visible")
	public void userVerifyLoginErrorMessageIsVisible(String warningMessageExpected) {
	    
		String warningMessageActual = loginPage.getloginWarningMessage();
		Assert.assertEquals(warningMessageActual, warningMessageExpected);
		
	}
	
}
