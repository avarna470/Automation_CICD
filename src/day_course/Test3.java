package day_course;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {
	
	@AfterMethod
	public void afMethod() {
		System.out.println("I will execute after every testcase in class Test3");
	}
	
	@Test
	public void webLoginCarLoan() {
		System.out.println("Web Login Car");
	}
	
	@Test(groups= {"Smoke"})
	public void mobileLoginCarLoan()
	{
		System.out.println("Mobile Login Car");
	}
	@Test(enabled=false)
	public void mobileSignupCarLoan()
	{
		System.out.println("Mobile SignUp Car");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am the most first executor of Suite");
	}
	@Parameters({"URL"})
	@Test
	public void mobileSignoutCarLoan(String urlname)
	{
		System.out.println("Mobile SignOut Car");
		System.out.println(urlname);
	}
	
	@Test(dependsOnMethods= {"webLoginCarLoan"})
	public void apiLoginCarLoan() {
		System.out.println("API Login Car");
	}
	
	@BeforeMethod
	public void bfMethod() {
		System.out.println("I will execute before every testcase of class Test3");
	}
	
}
