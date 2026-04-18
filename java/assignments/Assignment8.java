package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		Thread.sleep(3000);
		
		List<WebElement> options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement option:options) {
			String value=option.getText();
			if(value.contains("United States")) {
				option.click();
				break;
			}
		}
		
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		
		
		
	}

}
