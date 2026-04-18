package day_course;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample_Test {
	
	static WebDriver driver;
	
//	@AfterTest
//	public void afterExecute() {
//		System.out.println("I will execute after all Testcases in the Test folder");
//	}
//
//	@Test(groups= {"Smoke"})
//	public void test2() {
//		System.out.println("Sample Test");
//	}
//	@Parameters({"URL"})
//	@Test
//	public void loan(String uname) {
//		System.out.println("Personal Loan");
//		System.out.println(uname);
//	}
//	
	ChromeOptions options=new ChromeOptions();
	@Test
	public void automation() {
		
		driver=new ChromeDriver(options);
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		.sendKeys("hello_test").doubleClick().build().perform();
		
	}
	
	@Test
	public void cart() {
		
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
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
