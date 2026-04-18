package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Traverse {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Sibling Traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//Child to Parent Traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button[3]/parent::div/parent::header/div/button[1]")).getText());
		
		
	}

}
