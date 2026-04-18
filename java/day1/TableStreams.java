package day1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableStreams {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		// Comparing original list and sorted list
		List<String> originalList = items.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originalList, sortedList);

		//Price of an item & Pagination
		List<String> veg = null;
		do {

			List<WebElement> veggies = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			veg = veggies.stream().filter(s -> s.getText().equals("Strawberry")).map(s -> priceOfVeggie(s))
					.collect(Collectors.toList());
			if (veg.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (veg.size() < 1);
		System.out.println(veg);
		
		/*
		  for(WebElement item:items) { 
		  if(item.getText().equals("Rice")) {
		  String price=item.findElement(By.xpath("following-sibling::td[1]")).getText();
		  System.out.println(price); 
		  break; } 
		  }
		 */
		
		//Search Filter
		driver.findElement(By.id("search-field")).sendKeys("Tomato");
		List<WebElement> filt=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> values=filt.stream().filter(s->s.getText().contains("Tomato")).map(s->s.getText()).collect(Collectors.toList());
		
		Assert.assertEquals(filt.size(), values.size());

	}

	public static String priceOfVeggie(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return price;
	}

}
