package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMechanisum {
	
	
WebDriver driver;


public static WebElement waitForElementToPresents(WebDriver driver, WebElement locator,int timeout)
	
	{
		WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(timeout)); 
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));

		return locator;
		
		
	}

}
