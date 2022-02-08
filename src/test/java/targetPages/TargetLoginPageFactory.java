package targetPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TargetLoginPageFactory {


	public WebDriver driver;

	@FindBy(xpath="//body/div[@id='root']/div[@id='viewport']/div[3]/div[2]/nav[1]/a[7]")
	public WebElement mouseHoverSignIn;

	@FindBy(xpath="//body/div[13]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	public WebElement signIn;

	@FindBy(xpath="//input[@id='username']")
	public WebElement userName;

	@FindBy(xpath="//input[@id='password']")
	public WebElement password;

	@FindBy(xpath="//body/div[@id='__next']/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/label[1]/div[1]")
	public WebElement keepMeSignInCheckBox;

	@FindBy(xpath="//button[@id='login']")
	public WebElement loginButton;





	public TargetLoginPageFactory(WebDriver driver) //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void  mouseHoverSignIn()
	{
		Actions action=new Actions(driver);
		action.moveToElement(mouseHoverSignIn).click().perform();;
		
	}

	
}
