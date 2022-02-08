package targetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPageFactory {


	public WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Forgot password?')]")
		public WebElement forgotPassword;
	
	@FindBy(xpath="//body/div[@id='__next']/div[2]/div[1]/div[1]/div[1]/h2")
		public WebElement validateForgotPassword;
	
	@FindBy(xpath="//div[@for='otpSignin']")
		public WebElement signTemporaryCode;
	
	@FindBy(xpath="//button[@id='continue']")
		public WebElement sendCode;
	

	public ForgotPasswordPageFactory(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}


	}
