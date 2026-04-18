package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		driver.findElement(By.id("checkBoxOption3")).click();
		String text=driver.findElement(By.xpath("//label[@for='honda']")).getText();	
		
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		
		Select option=new Select(dropdown);
		option.selectByVisibleText(text);
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertmessage=driver.switchTo().alert().getText();
		String name=alertmessage.split(",")[0].split(" ")[1];
		System.out.println(name);
		
		Assert.assertEquals(name, "Option3");
		
	}

}
