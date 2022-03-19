package com.test.selenium.four.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterWindowAndTabManagement {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Title: " + driver.getTitle());
	}

	@Test
	public void testWorkingInBothWidnowTabs() {
		// Automatically Open & Switch To The New Window Or Tab
		driver.switchTo().newWindow(WindowType.TAB)
		    .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println("Title: " + driver.getTitle());
		
		// Work In The New Window Or Tab
		driver.findElement(By.id("email_create")).sendKeys("Selenium4@TA.com");
		driver.findElement(By.id("SubmitCreate")).click();
		
		// Get The Window ID Handles
	    Set<String> allWindowTabss = driver.getWindowHandles();
	    Iterator<String> iterate = allWindowTabss.iterator();
	    String mainFirstWindow = iterate.next();
		
		//Switch & Work In the Main Window Or Tab
	    driver.switchTo().window(mainFirstWindow);
	    driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
	    driver.findElement(By.name("submit_search")).click();
	    System.out.println("Title: " + driver.getTitle());
	    

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
