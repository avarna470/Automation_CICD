package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.className("react-date-picker__calendar-button")).click();

		String date = "12", month = "4", year = "2001";
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		// Year Method
		yearRange("2001");
		// Month
		driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']/button"))
				.get(Integer.parseInt(month) - 1).click();
		// Date
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		String value = "0", format = "";

		for (int k = 0; k < driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")).size(); k++) {

			value = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input")).get(k)
					.getAttribute("value");
			format += value + "/ ";
		}

		System.out.println(format);
		Assert.assertEquals(format, month + "/ " + date + "/ " + year + "/ ");

	}

	public static void yearRange(String year) {

		String yr = driver.findElement(By.className("react-calendar__navigation__label__labelText")).getText();

		String[] arr = yr.split(" ");

		Integer minyr = Integer.parseInt(arr[0]);
		Integer maxyr = Integer.parseInt(arr[2]);

		Integer yy = Integer.parseInt(year);

		if (yy < minyr) {
			driver.findElement(By.className("react-calendar__navigation__prev-button")).click();
			yr = driver.findElement(By.className("react-calendar__navigation__label__labelText")).getText();

			arr = yr.split(" ");

			minyr = Integer.parseInt(arr[0]);
			maxyr = Integer.parseInt(arr[2]);
			if (yy < minyr) {
				driver.findElement(By.className("react-calendar__navigation__prev-button")).click();
			}

		} else if (yy > maxyr) {
			driver.findElement(By.className("react-calendar__navigation__next-button")).click();

		}

		driver.findElement(By.xpath("//div[@class='react-calendar__decade-view__years']/button[text()='" + year + "']"))
				.click();

	}

}
