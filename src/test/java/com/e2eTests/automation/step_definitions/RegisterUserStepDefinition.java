package com.e2eTests.automation.step_definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.e2eTests.automation.page_objects.HomePage;
import com.e2eTests.automation.page_objects.LoginPage;
import com.e2eTests.automation.page_objects.RegisterUserPage;
import com.e2eTests.automation.utils.ConfigFileReader;
import com.e2eTests.automation.utils.Setup;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class RegisterUserStepDefinition {

	public HomePage homePage;
	public LoginPage loginPage;
	public RegisterUserPage registerUserPage;
	public ConfigFileReader configFileReader;
	
	public static List<String> myAddressInfo = new ArrayList<>();

	public RegisterUserStepDefinition() {

		homePage = new HomePage();
		loginPage = new LoginPage();
		registerUserPage = new RegisterUserPage();
		configFileReader = new ConfigFileReader();
	}

	@Given("User navigates to application")
	public void userNavigatesToApplication() {

		Setup.getDriver().get(configFileReader.getProperties("home.url"));

	}

	@Given("User verify that home page is visible successfully")
	public void UserVerifyThatHomePageIsVisibleSuccessfully() {

		String styleAttrActual = homePage.getAttributeOfElement();
		String styleAttrExpected = "color: orange;";
		Assert.assertEquals(styleAttrExpected, styleAttrActual);

	}

	@When("User clicks on SignupLogin button")
	public void userClicksOnSignupLoginButton() {

		homePage.clickOnBtnSignupLogin();

	}

	@When("User verify that new user {string} text is visible")
	public void userVerifyThatNewUserTextIsVisible(String signupTextExpected) {

		String signupTextActual = loginPage.getNewUserSignupText();
		Assert.assertEquals(signupTextExpected, signupTextActual);

	}

	@When("User enters name {string} and email address {string}")
	public void userEntersNameAndEmailAddress(String name, String email) {

		loginPage.enterNameAndEmailAddress(name, email);

	}

	@When("User clicks on Signup button")
	public void userClicksOnSignupButton() {

		loginPage.clickOnBtnSignup();

	}

	@When("User verify that Account Information {string} text is visible")
	public void userVerifyThatAccountInformationTextIsVisible(String accountInformationExpected) {

		String accountInformationActual = registerUserPage.getEnterAccountInformationText();
		Assert.assertEquals(accountInformationExpected, accountInformationActual);

	}

	@When("User chooses Title")
	public void userChoosesTitle() {

		registerUserPage.clickOnBtnRadio();

	}

	@When("User enters the details into account information fields")
	public void userEntersTheDetailsIntoAccountInformationFields(DataTable dataTableAccount) {

		Map<String, String> dataMap = dataTableAccount.asMap(String.class, String.class);

		registerUserPage.enterName(dataMap.get("name"));
		registerUserPage.enterPassword(dataMap.get("password"));
		
		myAddressInfo.add(dataMap.get("name"));

	}

	@When("User chooses Date of Birth")
	public void userChoosesDateOfBirth() {

		registerUserPage.selectDays("30");
		registerUserPage.selectMonths("January");
		registerUserPage.selectYears("1979");

	}

	@When("User select checkbox Sign up for our newsletter")
	public void userSelectCheckboxSignUpForOurNewsletter() {

		registerUserPage.clickOnCheckBoxNewsletter();

	}

	@When("User select checkbox Receive special offers from our partners")
	public void userSelectCheckboxReceiveSpecialOffersFromOurPartners() {

		registerUserPage.clickOnCheckBoxReceiveOffers();

	}

	@When("User enters the details into address information fields")
	public void userEntersTheDetailsIntoAddressInformationFields(DataTable dataTableAddress) {

		Map<String, String> dataMap = dataTableAddress.asMap(String.class, String.class);

		registerUserPage.enterFirstName(dataMap.get("firstName"));
		registerUserPage.enterLastName(dataMap.get("lastName"));
		registerUserPage.enterCompany(dataMap.get("company"));
		registerUserPage.enterFirstAddress(dataMap.get("address"));
		registerUserPage.enterSecondAddress(dataMap.get("address2"));
		registerUserPage.enterState(dataMap.get("state"));
		registerUserPage.enterCity(dataMap.get("city"));
		registerUserPage.enterZipCode(dataMap.get("zipcode"));
		registerUserPage.enterMobileNumber(dataMap.get("mobileNumber"));
		
		myAddressInfo.add(dataMap.get("company"));
		myAddressInfo.add(dataMap.get("address"));
		myAddressInfo.add(dataMap.get("address2"));
		myAddressInfo.add(dataMap.get("city"));
		myAddressInfo.add(dataMap.get("state"));
		myAddressInfo.add(dataMap.get("zipcode"));
		myAddressInfo.add(dataMap.get("mobileNumber"));

	}

	@When("User select a Country")
	public void userSelectACountry() {

		registerUserPage.selectCountry("Singapore");
		
		myAddressInfo.add("Singapore");

	}

	@When("User clicks on Create Account button")
	public void userClicksOnCreateAccountButton() {

		registerUserPage.clickOnBtnCreateAccount();

	}

	@When("User verify that Account Created {string} text is visible")
	public void userVerifyThatAccountCreatedTextIsVisible(String accountCreatedMessageExpected) {

		String accountCreatedMessageActual = registerUserPage.getAccountCreatedMessage();
		Assert.assertEquals(accountCreatedMessageExpected, accountCreatedMessageActual);

	}

	@When("User clicks on Continue button")
	public void userClicksOnContinueButton() {

		registerUserPage.clickOnBtnContinue();

	}

	@When("User verify that Logged UserName {string} text is visible")
	public void userVerifyThatLoggedUserNameTextIsVisible(String loggedMessageExpected) {

		String loggedMessageMessageActual = registerUserPage.getLoggedMessage();
		Assert.assertEquals(loggedMessageExpected, loggedMessageMessageActual);

	}

	@When("User clicks on Delete Account button")
	public void userClicksOnDeleteAccountButton() {

		registerUserPage.clickOnBtnDeleteAccount();

	}

	@Then("User verify that Account Deleted {string} text is visible")
	public void userVerifyThatAccountDeletedTextIsVisible(String accountDeletedMessageExpected) {

		String accountDeletedMessageActual = registerUserPage.getAccountDeletedMessage();
		Assert.assertEquals(accountDeletedMessageExpected, accountDeletedMessageActual);

	}

}
