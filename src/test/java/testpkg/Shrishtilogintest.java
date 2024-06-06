package testpkg;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import basepkg.Baseclass;
import pagepkg.Shrishtiloginpage;
import utilities.Excelutils;

public class Shrishtilogintest extends Baseclass
{
	
    @Test(priority=1)
    
    public void logintest()
    {
	    Shrishtiloginpage ob=new Shrishtiloginpage(driver);

       String xl="C:\\Users\\Acer\\Desktop\\ARATHY\\LUMINAR\\excel work\\Shrishti.xlsx";
       String Sheet="Sheet1";
       int rowCount=Excelutils.getRowCount(xl,Sheet);
    
       for(int i=1;i<=rowCount;i++)
       {
    	   String Un=Excelutils.getCellValue(xl,Sheet,i,0);
    	   System.out.println("username...." +Un);
    	 
    	   String Pswd=Excelutils.getCellValue(xl,Sheet,i,1);
    	   System.out.println("password...." +Pswd);
    	 
    	   ob.setvalues(Un, Pswd);                                                                              //passing un and pwd as parameters
    	   ob.loginclick();                                                                                     //clicking login button
       }	
    }

    @Test(priority=2)
    public void search() throws AWTException
    {
	   driver.findElement(By.xpath("//*[@id=\"nav-menu-item-7140\"]/a/span")).click();                             //click home option
	   driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys("bangles");        //search bangles
	   
	   Robot robot=new Robot();                                                                                //to press enter after passing bangles
	   robot.delay(3000);
	   robot.keyPress(KeyEvent.VK_ENTER);
	   robot.keyRelease(KeyEvent.VK_ENTER);
    }
   
    @Test(priority=3)
    public void addtocart() throws Exception
    {
    	  driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div[2]/a")).click();
    	  driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[5]/div[2]/a")).click();
    	  
    }
    
    
    
    @Test(priority=4)
    public void checkout() throws Exception 
    {
     	   Thread.sleep(5000);    	  
	       driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/div[3]")).click();                                //click close button
	       
    	
    }
    
    @Test(priority=4)
    public void clickcollection() 
    {
    	
    	 WebElement collections=driver.findElement(By.xpath("//*[@id=\"nav-menu-item-7803\"]/a/span"));             //mousehover collections
    	 
    	 Actions act=new Actions(driver);
    	 act.moveToElement(collections);
    	 act.perform();
    	 
    	 driver.findElement(By.xpath("//*[@id=\"nav-menu-item-7804\"]/a/span")).click();                   //click american diamond inside collections
    	 
    	 WebElement sortdetails=driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/form/select"));               //select sort by latest
    	 Select sort=new Select(sortdetails);
    	 sort.selectByVisibleText("Sort by latest");
    	 
    }
    
    @Test(priority=5)
    public void viewcart()
    {
    	 driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/ul/li/div/a/span[2]")).click();                           //clicking cart icon
    	 driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/div[4]/div/p[2]/a[1]")).click();                            //clicking view cart option
    	 driver.findElement(By.xpath("//*[@id=\"menu-item-7001\"]/a/div")).click();                                           //checkout
    }
    
    
    @Test(priority=6)	 
    public void billing()
    {
    	 driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Arathy");                           //firstname
    	 driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Gopinath");                           //lastname
    	 driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("Periya");                            //street
    	 driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Kanhangad");                               //town
    	 driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("671316");                                 //pin
    	 driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("9987654323");                                //phone
    	                                               
    	 driver.navigate().back();
    }
    	 
    	 
    @Test(priority=7)
    public void screenshot() throws IOException
    {
    	File src=(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
    	FileHandler.copy(src, new File("D://Shrishtiscreenshot.png"));
    }

}
