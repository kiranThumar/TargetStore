

package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties property;
	
	public WebDriver initializeDrievr() throws IOException {
		
		
		
		property=new Properties(); //create a object in a properties class
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		property.load(file);
		
		String browserName=property.getProperty("browser");
		if(browserName.contains("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe"));
			driver=new ChromeDriver();
			
		}
		else if(browserName.contains("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe"));
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		return driver;
		
		
	}

}
