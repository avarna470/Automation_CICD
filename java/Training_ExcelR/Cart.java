package Training_ExcelR;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("avarnakathi1246@gmail.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("tricentis@123");
		driver.findElement(By.cssSelector("input#RememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.linkText("Computers")).click();
		driver.findElement(By.xpath("//a[@title='Show products in category Desktops']")).click();
		List<WebElement> items=driver.findElements(By.xpath("//div[@class='add-info']/div[@class='buttons']/input"));
		
		/*Set<String> tabs=driver.getWindowHandles();
		Iterator<String> id=tabs.iterator();
		String parentID=id.next();
		String childID=id.next();*/
		int i=0;
		for(WebElement item:items) {
			item.click();
			Thread.sleep(2000);
			driver.findElement(By.className("add-to-cart-button")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			
			
		}
		
		driver.findElement(By.id("topcartlink")).click();
		driver.findElement(By.cssSelector("#termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		
		
	}

}
