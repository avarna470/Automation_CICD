package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Above
		WebElement nameTextBox=driver.findElement(By.xpath("//input[@name='name']"));	
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
		
		//Below
		WebElement dobLabel=driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
		
		//Left
		WebElement checboxLabel=driver.findElement(By.className("form-check-label"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checboxLabel)).click();
		
		//Right
		WebElement radioButton=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
	}

}
