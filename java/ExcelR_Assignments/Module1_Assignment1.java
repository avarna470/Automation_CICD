package ExcelR_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Module1_Assignment1 {
	
	public static void main(String[] args) {
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\a\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/radio.html");
		
		System.out.println(driver.getTitle());
		
		//Radio button Select
		driver.findElement(By.xpath("//input[@value='Option 1']")).click();
		//CheckBox Select
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][3]")).click();
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		Select option=new Select(driver.findElement(By.name("country")));
		option.selectByValue("KUWAIT");
		
		
	}

}
