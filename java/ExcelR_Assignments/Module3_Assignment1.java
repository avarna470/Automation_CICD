package ExcelR_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Module3_Assignment1 {
	
	static WebDriver driver;
	
	@BeforeTest
	public void websiteLaunch() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/login.html");
		
	}
	
	@Test(dataProvider="getData")
	public void credentials(String Username,String Password) throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(Username);
		driver.findElement(By.id("passwd")).sendKeys(Password);
		Thread.sleep(4000);
	}
	
	@DataProvider
	public String[][] getData() {
		
		String[][] arr=new String[1][2];
		
		arr[0][0]="avarnakathi1246@gmail.com";
		arr[0][1]="TestUser@123";
		
		return arr;
	}
	
	@AfterTest
	public void browserClose() {
		driver.close();
	}
	
}
