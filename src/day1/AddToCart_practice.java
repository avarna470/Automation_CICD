package day1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart_practice {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] items = { "Brocolli", "Cucumber", "Brinjal", "Tomato", "Potato", "Onion", "Mushroom" };
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		addItems(items);
		
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//a/img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.className("promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());	
	}

	public static void addItems(String[] items) {
		List<WebElement> veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));

		int j = 0;
		for (int i = 0; i < veggies.size(); i++) {

			String[] arr = veggies.get(i).getText().split(" ");
			String veg = arr[0];

			// List<String> l = Arrays.asList(items);
			for (String s : items) {
				if (s.equalsIgnoreCase(veg)) {
					j++;
					driver.findElement(By.xpath("//h4[contains(text(),'" + veg
							+ "')]/following-sibling::div[@class='product-action']/button")).click();

					if (j == items.length) {
						break;
					}

				}
			}

		}
	}
}
