package com.test.selenium.four.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterElementPosition {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationu.applitools.com/learningpaths.html");
	}

	@Test
	public void getPositionDimension() {
		WebElement logoTAU = driver.findElement(By.xpath(
				"//div[@id='app']//header/a/img"));
		
	 Rectangle rectTAULogo = logoTAU.getRect();
	 
	 System.out.println("x: " + rectTAULogo.getX());
	 System.out.println("x: " + rectTAULogo.getY());
	 System.out.println("x: " + rectTAULogo.getWidth());
	 System.out.println("x: " + rectTAULogo.getHeight());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
