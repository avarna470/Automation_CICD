package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	public static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("WebDriver.chrome.driver", "C:\\Users\\a\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64");
			
			//ChromeDriver driver=new ChromeDriver();
			
			//EdgeDriver driver =new EdgeDriver();
			
			/*driver=new EdgeDriver();
			Thread.sleep(3000);
			//driver.close();
			driver.get("https://www.instagram.com");
			Thread.sleep(3000);
			driver.quit();*/
			
			driver=new ChromeDriver();
			Thread.sleep(3000);
			//driver.close();
			driver.get("https://www.facebook.com");		
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(3000);
			
			driver.quit();
			
			
			
			
	}

}
