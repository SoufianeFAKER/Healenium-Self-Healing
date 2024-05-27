package com.e2eTests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.BasePage;
import com.e2eTests.automation.utils.SelectFromListUtils;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.Setup;
import com.e2eTests.automation.utils.Validations;

public class RegisterUserPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//b[normalize-space()='Enter Account Information']")
	private static WebElement enterAccountInformationText;

	@FindBy(how = How.ID, using = "id_gender1")
	private static WebElement btnRadio;

	@FindBy(how = How.ID, using = "name")
	private static WebElement fieldName;

	@FindBy(how = How.ID, using = "email")
	private static WebElement fieldEmail;

	@FindBy(how = How.ID, using = "password")
	private static WebElement fieldPassword;

	@FindBy(how = How.ID, using = "days")
	private static WebElement daysSelect;

	@FindBy(how = How.ID, using = "months")
	private static WebElement monthsSelect;

	@FindBy(how = How.ID, using = "years")
	private static WebElement yearsSelect;
	
	@FindBy(how = How.ID, using = "newsletter")
	private static WebElement checkBoxNewsletter;
	
	@FindBy(how = How.ID, using = "optin")
	private static WebElement checkBoxReceiveOffers;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='first_name']")
	private static WebElement fieldFirstName;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='last_name']")
	private static WebElement fieldLastName;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='company']")
	private static WebElement fieldCompany;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='address']")
	private static WebElement fieldAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='address2']")
	private static WebElement fieldAddress2;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='state']")
	private static WebElement fieldState;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='city']")
	private static WebElement fieldCity;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='zipcode']")
	private static WebElement fieldZipCode;
	
	@FindBy(how = How.XPATH, using = "//input[@data-qa='mobile_number']")
	private static WebElement fieldMobileNumber;
	
	@FindBy(how = How.XPATH, using = "//select[@data-qa='country']")
	private static WebElement countrySelect;
	
	@FindBy(how = How.XPATH, using = "//button[@data-qa='create-account']")
	private static WebElement btnCreateAccount;
	
	@FindBy(how = How.XPATH, using = "//b[normalize-space()='Account Created!']")
	private static WebElement accountCreatedMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@data-qa='continue-button']")
	private static WebElement btnContinue;
	
	@FindBy(how = How.XPATH, using = "//li[10]//a[1]")
	private static WebElement loggedMessage;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Delete Account']")
	private static WebElement btnDeleteAccount;
	
	@FindBy(how = How.XPATH, using = "//b[normalize-space()='Account Deleted!']")
	private static WebElement accountDeletedMessage;

	public SeleniumUtils seleniumUtils;
	public Validations validations;
	public SelectFromListUtils selectFromListUtils;

	public RegisterUserPage() {

		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();
		validations = new Validations();
		selectFromListUtils = new SelectFromListUtils();
	}

	

	public String getEnterAccountInformationText() {

		return seleniumUtils.readText(enterAccountInformationText);
	}

	public void clickOnBtnRadio() {

		seleniumUtils.click(btnRadio);
	}

	public void enterName(String nameText) {

		seleniumUtils.writeText(fieldName, nameText);
	}

	public void enterEmail(String emailText) {

		seleniumUtils.writeText(fieldEmail, emailText);

	}

	public void enterPassword(String passwordText) {

		seleniumUtils.writeText(fieldPassword, passwordText);
	}

	public void selectDays(String daysText) {

		selectFromListUtils.selectDropDownListByVisibleText(daysSelect, daysText);

	}

	public void selectMonths(String monthsText) {

		selectFromListUtils.selectDropDownListByVisibleText(monthsSelect, monthsText);

	}
	
	public void selectYears(String yearsText) {

		selectFromListUtils.selectDropDownListByVisibleText(yearsSelect, yearsText);

	}
	
	public void clickOnCheckBoxNewsletter() {
		
		seleniumUtils.click(checkBoxNewsletter);
		
	}
	
	public void clickOnCheckBoxReceiveOffers() {
		
		seleniumUtils.click(checkBoxReceiveOffers);
		
	}
	
	public void enterFirstName(String firstNameText) {
		
		seleniumUtils.writeText(fieldFirstName, firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		seleniumUtils.writeText(fieldLastName, lastNameText);
		
	}
	
	public void enterCompany(String companyText) {
		
		seleniumUtils.writeText(fieldCompany, companyText);
		
	}
	
	public void enterFirstAddress(String firstaddressText) {
		
		seleniumUtils.writeText(fieldAddress, firstaddressText);
		
	}
	
	public void enterSecondAddress(String secondAddressText) {
		
		seleniumUtils.writeText(fieldAddress2, secondAddressText);
		
	}
	
	public void enterState(String stateText) {
		
		seleniumUtils.writeText(fieldState, stateText);
		
	}
	
	public void enterCity(String cityText) {
		
		seleniumUtils.writeText(fieldCity, cityText);
		
	}
	
	public void enterZipCode(String zipCodeText) {
		
		seleniumUtils.writeText(fieldZipCode, zipCodeText);
		
	}
	
	public void enterMobileNumber(String mobileNumberText) {
		
		seleniumUtils.writeText(fieldMobileNumber, mobileNumberText);
		
	}
	
	public void selectCountry(String countryText) {
		
		selectFromListUtils.selectDropDownListByVisibleText(countrySelect, countryText);
		
	}
	
	public void clickOnBtnCreateAccount() {
		
		seleniumUtils.click(btnCreateAccount);
		
	}
	
	public String getAccountCreatedMessage() {
		
		return seleniumUtils.readText(accountCreatedMessage);
	}
	
	public void clickOnBtnContinue() {
		
		seleniumUtils.click(btnContinue);
		
	}
	
	public String getLoggedMessage() {
		
		return seleniumUtils.readText(loggedMessage);
	}
	
	public void clickOnBtnDeleteAccount() {
		
		seleniumUtils.click(btnDeleteAccount);
	}
	
	public String getAccountDeletedMessage() {
		
		return seleniumUtils.readText(accountDeletedMessage);
	}
	

}
