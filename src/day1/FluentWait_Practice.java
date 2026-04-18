package day1;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait_Practice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		/*Thread.sleep(10);
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(3));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='start']/button")));
		*/
		
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//FluentWait
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		
		//WebElement foo=
		wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
				return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				else 
					return null;
			}
		});
		
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());		
		
		
	}

}
