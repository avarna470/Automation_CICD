package day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Switching Multiple Tabs
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> IDs=driver.getWindowHandles();
		Iterator<String> Id=IDs.iterator();
		String parentId=Id.next();
		String childId=Id.next();
		
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/learning-paths");
		
		String coursefirst=driver.findElement(By.xpath("//div[@class='p-4']/h3[1]")).getText();
		driver.switchTo().window(parentId);
		WebElement name=driver.findElement(By.name("name"));
		name.sendKeys(coursefirst);
		
		//Partial or Element Screenshot
		File f=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("ElementScreenshot.png"));
		
		//Get Dimensions of an Element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
