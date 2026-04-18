package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		int RowSize=driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr")).size();
		int ColumnSize=driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr/th")).size();
		
		System.out.println("No.of rows is: "+RowSize);
		System.out.println("No.ofColumns is: "+ColumnSize);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr[3]")).getText());

	}

}
