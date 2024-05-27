package com.e2eTests.automation.step_definitions;

import org.junit.Assert;

import com.e2eTests.automation.page_objects.HomePage;
import com.e2eTests.automation.page_objects.LoginPage;

import io.cucumber.java.en.*;

public class LoginValidCredentialsStepDefinition {
	
	public HomePage homePage = new HomePage();
	public LoginPage loginPage = new LoginPage(); 
	
	@Given("User navigates to home Page")
	public void userNavigatesToHomePage() {
		
		homePage.clicksOnBtnHome();
	    
	}
	
	@When("User verify that login to your account {string} text is visible")
	public void userVerifyThatLoginToYourAccountTextIsVisible(String loginAccountExpected) {
		
		String loginAccountActual = loginPage.getLoginAccountMessage();
		Assert.assertEquals(loginAccountExpected, loginAccountActual);
	    
	}
	
	@When("User enters email {string} and password {string}")
	public void userEntersEmailAndPassword(String email, String password) {
		
		loginPage.enterEmailToLogin(email);
		loginPage.enterPasswordToLogin(password);
	    
	}
	
	@When("User clicks on Login button")
	public void userClicksOnLoginButton() {
		
		loginPage.clickOnBtnLoginButton();
	    
	}




}
