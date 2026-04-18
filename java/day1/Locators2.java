package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://sso.teachable.com/secure/9521/identity/sign_up/otp");
		
		driver.findElement(By.linkText("Log in")).click();
		
		//Login with password
		driver.findElement(By.className("loginPasswordBtn")).click();
		driver.findElement(By.xpath("//div[contains(@class,'m')]/input[@name='email']")).sendKeys("kathiavarna98@gmail.com");
		driver.findElement(By.cssSelector("div[class*='container'] input[id='password']")).sendKeys("rahulshettyacademy");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();

		
		//Logout action
		System.out.println(driver.findElement(By.xpath("//section/h2[2]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//section/h2[2]")).getText(), "Welcome back Avarna. Let's learn something today!");
		
		driver.findElement(By.id("radix-:R17ah9ukq:")).click();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
		driver.close();
	
	}

}
