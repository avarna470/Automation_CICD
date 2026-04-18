package day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class links_topic {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Limiting WebDriver Scope
		WebElement footerdriver=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		int linkssize=columndriver.findElements(By.tagName("a")).size();
	
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		for(int i=1;i<=linkssize;i++) {
			//wait.until(ExpectedConditions.refreshed(ExpectedConditions
			//.presenceOfElementLocated(By.xpath("//h1[text()='Practice Page']"))));
			try {
			columndriver.findElements(By.tagName("a")).get(i).click();
			driver.navigate().back();
			}
			catch(StaleElementReferenceException e) {
				
				driver.navigate().refresh();
				WebElement element=columndriver.findElements(By.tagName("a")).get(i);
				element.click();
			}
			
		}*/
		
		for(int i=1;i<linkssize;i++) {
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		
		Set<String> tabs=driver.getWindowHandles();
		
		Iterator<String> it=tabs.iterator();
		int a=0;
		while(it.hasNext()) {
			String ID=it.next();
			System.out.println(driver.switchTo().window(ID).getTitle());
		}
		
		
	}

}
