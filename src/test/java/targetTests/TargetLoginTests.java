package targetTests;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;
import targetPages.TargetLoginPageFactory;
import utils.WaitMechanisum;

public class TargetLoginTests extends Base {

	public WebDriver driver;
	//public static Logger log=LogManager.getLogger(base.class.getName());
	public static Logger logger=LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		
		driver=initializeDrievr();
		
		
	}
	
	@Test(dataProvider="getLoginData")
	public void loginPageTest(String userName,String password)
	{
		driver.get(property.getProperty("url"));

		TargetLoginPageFactory targetLoginPageFactory=new TargetLoginPageFactory(driver);
		logger.info("Valid User Login");

		targetLoginPageFactory.mouseHoverSignIn();
		WaitMechanisum.waitForElementToPresents(driver,targetLoginPageFactory.signIn,10).click();;
		targetLoginPageFactory.userName.sendKeys(userName);
		targetLoginPageFactory.password.sendKeys(password);
		targetLoginPageFactory.keepMeSignInCheckBox.click();
		targetLoginPageFactory.loginButton.click();
		logger.info("Invalid User Login");

		
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		
		Object[][] loginData=new Object[2][2];
		loginData[0][0]="SANJAY.VASOYA@GMAIL.COM";
		loginData[0][1]="dknnsks";
		loginData[1][0]="kiranthummar";
		loginData[1][1]="dljljdl";
		return loginData;
		
	}


	@AfterTest
	public void tearDwon()
	{
		driver.quit();
	}
	
}
