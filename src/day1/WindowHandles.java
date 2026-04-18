package day1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> it=tabs.iterator();
		String parentID=it.next();
		String childID=it.next();
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		String username=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//System.out.println(username);
		
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(username);
		
		
		
	}

}
