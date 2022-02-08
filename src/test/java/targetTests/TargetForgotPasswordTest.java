package targetTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;
import targetPages.ForgotPasswordPageFactory;
import targetPages.TargetLoginPageFactory;
import utils.WaitMechanisum;

public class TargetForgotPasswordTest extends Base{

	public WebDriver driver;
	public static Logger logger=LogManager.getLogger(Base.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{

		driver=initializeDrievr();
		logger.info("Navigated to Forgot Password Page");


	}
	@SuppressWarnings("deprecation")
	@Test()
	public void forgotPassword()
	{
		driver.get(property.getProperty("url"));

		TargetLoginPageFactory targetLoginPageFactory=new TargetLoginPageFactory(driver);
		ForgotPasswordPageFactory forgotPassword=new ForgotPasswordPageFactory(driver);

		targetLoginPageFactory.mouseHoverSignIn();
		WaitMechanisum.waitForElementToPresents(driver,targetLoginPageFactory.signIn,10).click();;
		targetLoginPageFactory.userName.sendKeys("SANJAY.VASOYA@GMAIL.COM");
		forgotPassword.forgotPassword.click();
		forgotPassword.signTemporaryCode.click();
		Assert.assertEquals(forgotPassword.validateForgotPassword.getText(),"Forgot Password");
		logger.info("Successfully Validate forgot Password Title");
		forgotPassword.sendCode.click();

	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
