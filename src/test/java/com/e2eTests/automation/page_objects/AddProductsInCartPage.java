package com.e2eTests.automation.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTests.automation.utils.BasePage;
import com.e2eTests.automation.utils.SeleniumUtils;
import com.e2eTests.automation.utils.Setup;

public class AddProductsInCartPage extends BasePage {

	@FindBy(how = How.XPATH, using = "(//img[@alt='ecommerce website products'])[1]") 
	private static WebElement productBox_1;

	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[2]")
	private static WebElement btnAddToCartBox_1;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Continue Shopping']")
	private static WebElement btnContinueShopping;

	@FindBy(how = How.XPATH, using = "(//img[@alt='ecommerce website products'])[2]")
	private static WebElement productBox_2;

	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[4]")
	private static WebElement btnAddToCartBox_2;

	@FindBy(how = How.XPATH, using = "//u[normalize-space()='View Cart']")
	private static WebElement btnViewCart;

	@FindBy(how = How.XPATH, using = "//tbody")
	private static WebElement tableProducts;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_price']")
	private static WebElement priceBox;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_quantity']")
	private static WebElement quantityBox;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_total']")
	private static WebElement totalBox;

	public SeleniumUtils seleniumUtils;

	public AddProductsInCartPage() {

		super(Setup.getDriver());
		seleniumUtils = new SeleniumUtils();

	}

	public void hoverOverFirstPruduct() {

		JavascriptExecutor js = (JavascriptExecutor) Setup.getDriver();
		js.executeScript(
				"const elements = document.querySelectorAll('.adsbygoogle.adsbygoogle-noablate'); for (let i = 0; i < elements.length; i++) elements[i].remove()");
		js.executeScript("window.scrollBy(0, 400);", productBox_1);

		Actions action = new Actions(Setup.getDriver());
		action.moveToElement(productBox_1).build().perform();

	}

	public void clickOnBtnAddToCartInBox1() {

		seleniumUtils.click(btnAddToCartBox_1);

	}

	public void clickOnBtnContinueShopping() {

		seleniumUtils.click(btnContinueShopping);

	}

	public void hoverOverSecondPruduct() {

		Actions action = new Actions(Setup.getDriver());
		action.moveToElement(productBox_2).build().perform();

	}

	public void clickOnBtnAddToCartInBox2() {

		seleniumUtils.click(btnAddToCartBox_2);

	}

	public void clickOnBtnViewCart() {

		seleniumUtils.click(btnViewCart);

	}

	public int verifyNbreOfProducts() {

		// Setup.getDriver().findElements(By.xpath("//tbody/tr"));

		List<WebElement> elements = tableProducts.findElements(By.tagName("tr"));

		return elements.size();

	}

	public boolean verifyPriceQuantityTotal() {

		List<WebElement> elements = tableProducts.findElements(By.tagName("tr"));

		Integer succesValidation = 0;

		for (WebElement element : elements) {

			String strPrice = element.findElement(By.className("cart_price")).getText();
			String price = strPrice.substring(4);
			int priceVal = Integer.parseInt(price);

			String quantity = element.findElement(By.className("cart_quantity")).getText();
			int quantityVal = Integer.parseInt(quantity);

			String strTotal = element.findElement(By.className("cart_total")).getText();
			String total = strTotal.substring(4);
			int totalVal = Integer.parseInt(total);

			if (priceVal * quantityVal == totalVal) {

				succesValidation++;

			}

		}

		return succesValidation.equals(elements.size());

	}

}
