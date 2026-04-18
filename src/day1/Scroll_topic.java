package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll_topic {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		Integer sum=0;
		for(int i=0;i<values.size();i++) {
			sum+=Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
		String totaltext=driver.findElement(By.cssSelector(".totalAmount")).getText();
		
		String val=totaltext.split(":")[1].trim();
		
		int res=Integer.parseInt(val);
		
		Assert.assertEquals(sum, res);
		
		
	}

}
