package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> it=tabs.iterator();
		String parentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
	}

}
