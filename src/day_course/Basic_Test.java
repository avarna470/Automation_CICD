package day_course;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Basic_Test {
	
	static WebDriver driver;
	
	
//	@Test
//	public void demo() {
//		System.out.println("TestNG framework Selenium Course");
//		Assert.assertTrue(true);
//	}
//	
//	@AfterSuite
//	public void afSuite() {
//		System.out.println("I am the last executor of Suite");
//	}
	
	@Test
	public void initializeBrowser() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\a\\TestNG_Jenkins\\src\\JavaStreams\\launch.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		
		String browsername= System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");		
	
		//new comments
System.out.println("HI CICD Jenkins Github");
		ChromeOptions options=new ChromeOptions();
		//if(browsername.contains("chrome")) {
			
			//if(browsername.contains("headless")) {
			//options.addArguments("headless");
			//}
			driver=new ChromeDriver(options);
			Basic_Test.function();
			
			
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
			Basic_Test.function();	
		
	}
	}
	
	public static void function() throws InterruptedException {
		//Static dropdown
		driver.manage().window().setSize(new Dimension(1440,900));
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				WebElement static_dropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown=new Select(static_dropdown);
				dropdown.selectByIndex(3);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				//Thread.sleep(3000);
				dropdown.selectByVisibleText("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				//Thread.sleep(3000);
				dropdown.selectByValue("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				
				//driver.findElement(By.id("divpaxinfo")).click();
				//Dynamic Dropdown
				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				//driver.findElement(By.xpath("//a[@value='HYD']")).click();
				//driver.findElement(By.xpath("//a[@value='BLR'][1]")).click();
				
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='HYD']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();

				driver.findElement(By.id("autosuggest")).sendKeys("Ind");
				Thread.sleep(2000);
				List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
				
				for(WebElement option:options)
				
					if(option.getText().equalsIgnoreCase("India")) {
						option.click();
						break;
					}
				
				//Checkbox selecting
				Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
				driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
				Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());		
				
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
				
				//Checking if field is enabled or disabled
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
				
				if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
					System.out.println("field is enabled");
					Assert.assertTrue(true);
				}
				else 
					Assert.assertTrue(false);
				
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
				if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
					System.out.println("field is disabled");
					Assert.assertTrue(true);
				}
				else 
					Assert.assertTrue(false);
				
				//Clicking on search button for flights
				driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	
	
}
