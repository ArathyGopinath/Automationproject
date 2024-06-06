package basepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Baseclass {
	public static WebDriver driver;
	String baseurl="https://shrishtijewels.in/my-account/";
	@BeforeTest
	public void setup()
	{
	       driver=new ChromeDriver();
	       driver.get(baseurl);
	       
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

}
