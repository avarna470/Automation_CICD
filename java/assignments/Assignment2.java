package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("TestUser");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("TestUser123@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test@321");
		driver.findElement(By.id("exampleCheck1")).click();
		
		Select option=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		option.selectByVisibleText("Female");	
		
		driver.findElement(By.xpath("//input[@name='inlineRadioOptions']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("1205");
		Actions move=new Actions(driver);
		move.sendKeys(Keys.ARROW_RIGHT,"2001").perform();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(driver.findElement(By.className("alert")).getText());
	}

}
