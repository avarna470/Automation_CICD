package day_course;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {
	
	
	@Test(timeOut=4000)
	public void webLoginHomeLoan() {
		System.out.println("Web Login Home");
	}
	
	@Test(dataProvider="getData")
	public void mobileLoginHomeLoan(String usrname, String paswrd)
	{
		System.out.println("Mobile Login Home");
		System.out.println(usrname+","+paswrd);
	}
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void apiLoginHomeLoan(String ulname) {
		System.out.println("API Login Home");
		System.out.println(ulname);
	}

	@BeforeTest
	public void beforeExceute() {
		System.out.println("I will execute at first of TestFolder");
	}
	
	@DataProvider
	public String[][] getData() {
		String[][] arr=new String[3][2];
		//1st data set
		arr[0][0]="firstUsername";
		arr[0][1]="firstPassword";
		//2nd data set
		arr[1][0]="secondUsername";
		arr[1][1]="secondPassword";
		//3rd data set
		arr[2][0]="thirdUsername";
		arr[2][1]="thirdPassword";
		
		return arr;
		
	}
	
}
