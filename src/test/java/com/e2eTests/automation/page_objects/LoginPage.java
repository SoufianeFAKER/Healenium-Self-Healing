package com.e2eTests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.BasePage;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.Setup;

public class LoginPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='New User Signup!']")
	private static WebElement newUserSignupText;

	@FindBy(how = How.XPATH, using = "//input[@data-qa='signup-name']")
	private static WebElement fieldSignupName;

	@FindBy(how = How.XPATH, using = "//input[@data-qa='signup-email']")
	private static WebElement fieldSignupEmail;

	@FindBy(how = How.XPATH, using = "//button[@data-qa='signup-button']")
	private static WebElement btnSignup;

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='Login to your account']")
	private static WebElement loginAccountMessage;

	@FindBy(how = How.XPATH, using = "//input[@data-qa='login-email']")
	private static WebElement fieldLoginEmail;

	@FindBy(how = How.XPATH, using = "//input[@data-qa='login-password']")
	private static WebElement fieldLoginPassword;

	@FindBy(how = How.XPATH, using = "//button[@data-qa='login-button']")
	private static WebElement btnLoginButton;

	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Your email or password is incorrect!']")
	private static WebElement loginWarningMessage;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Email Address already exist!']")
	private static WebElement registerWarningMessage;

	public SeleniumUtils seleniumUtils;

	public LoginPage() {

		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();

	}

	public String getLoginPageUrl() {

		return Setup.getDriver().getCurrentUrl();

	}

	public String getNewUserSignupText() {

		return seleniumUtils.readText(newUserSignupText);

	}

	public void enterNameAndEmailAddress(String nameText, String emailText) {

		seleniumUtils.writeText(fieldSignupName, nameText);
		seleniumUtils.writeText(fieldSignupEmail, emailText);

	}

	public void clickOnBtnSignup() {

		seleniumUtils.click(btnSignup);
	}

	public String getLoginAccountMessage() {

		return seleniumUtils.readText(loginAccountMessage);

	}

	public void enterEmailToLogin(String emailText) {

		seleniumUtils.writeText(fieldLoginEmail, emailText);

	}

	public void enterPasswordToLogin(String passwordText) {

		seleniumUtils.writeText(fieldLoginPassword, passwordText);

	}

	public void clickOnBtnLoginButton() {

		seleniumUtils.click(btnLoginButton);

	}

	public String getloginWarningMessage() {

		return seleniumUtils.readText(loginWarningMessage);

	}

	public String getRegisterWarningMessage() {

		return seleniumUtils.readText(registerWarningMessage);

	}

}
