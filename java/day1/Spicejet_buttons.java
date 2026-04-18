package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Spicejet_buttons {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		//Plus button for increasing no.of members in booking
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[contains(@data-testid,'travellers')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@data-testid,'travellers')]")).getText());
		for(int i=1;i<5;i++) {
			driver.findElement(By.xpath("//div[contains(@data-testid,'plus-one')]")).click();
		}
		System.out.println(driver.findElement(By.xpath("//div[contains(@data-testid,'travellers')]")).getText());
		driver.findElement(By.xpath("//div[contains(@data-testid,'done')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='5 Adults']")).getText(),"5 Adults");
		
	}

}
