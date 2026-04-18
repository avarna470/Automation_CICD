package day1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");

		SoftAssert sa = new SoftAssert(); 

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

		for (WebElement link : links) {

			String url = link.getAttribute("href");// REST API

			URI obj = new URI(url);
			HttpURLConnection conct = (HttpURLConnection) obj.toURL().openConnection();
			conct.setRequestMethod("HEAD");
			conct.connect();

			int respcode = conct.getResponseCode();
			System.out.println(respcode);
			
			sa.assertFalse(respcode > 400, "The url of Text '"+link.getText()+"' is broken with code "+respcode);
			
		}
		
		sa.assertAll();
	}

}
