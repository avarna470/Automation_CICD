package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args){
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("Learning@830$3mK2");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		Select option=new Select(driver.findElement(By.xpath("//select[@data-style='btn-info']")));
		option.selectByVisibleText("Consultant");
		
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("iphone X")));
		
		//Add to Cart
		List<WebElement> mobiles = driver.findElements(By.xpath("//h4[@class='card-title']/parent::div/following-sibling::div/button"));

		for (int i = 0; i < mobiles.size(); i++) {
			mobiles.get(i).click();
		}
		
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
	}

}
