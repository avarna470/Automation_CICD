package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames_topic {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dstn = driver.findElement(By.id("droppable"));

		Actions a = new Actions(driver);
		a.dragAndDrop(src, dstn).build().perform();

		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//h2[text()='Examples']")).getText());
	}

}
