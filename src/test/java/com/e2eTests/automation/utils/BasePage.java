package com.e2eTests.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;


public class BasePage {
	
	/** log. */
	protected static Logger log = LogManager.getLogger();
	
	//protected WebDriver driver;
	
	protected SelfHealingDriver driver;
	
	public BasePage(SelfHealingDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
