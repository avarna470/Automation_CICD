package ExcelR_Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module2_Assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> names=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		
		for(WebElement name:names) {
			System.out.println(name.getText());
		}
		
	}

}
