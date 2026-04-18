package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicLocator {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://sso.teachable.com/secure/9521/identity/sign_up/otp");
		//driver.findElement(By.id("name")).sendKeys("TestUser");
		driver.findElement(By.id("email")).sendKeys("avarnakathi@abc.com");
		driver.findElement(By.id("otp-login-btn")).click();	
		//System.out.println(driver.findElement(By.cssSelector("span#my-error-id")).getText());//For wrong emailId
		
		System.out.println(driver.findElement(By.xpath("//span[@id='my-error-id']")).getText());
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("TestUser");
		driver.findElement(By.id("otp-login-btn")).click();	
		driver.findElement(By.linkText("Log in")).click();
		
		
		//Login with password
		driver.findElement(By.className("loginPasswordBtn")).click();
		driver.findElement(By.name("email")).sendKeys("Avarna");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hello@123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.xpath("//div[contains(@class,'m')]/input[@name='email']")).sendKeys("kathiavarna98@gmail.com");
		driver.findElement(By.cssSelector("div[class*='container'] input[id='password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div/input[2]")).click();
		driver.findElement(By.xpath("//div/input[2]")).click();

		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
	}

}
