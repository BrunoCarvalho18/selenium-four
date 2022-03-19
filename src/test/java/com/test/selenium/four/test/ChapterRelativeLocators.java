package com.test.selenium.four.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterRelativeLocators {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test
	public void testRelativeLocator() {
		WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
		WebElement credentials = driver.findElement(RelativeLocator.with(
				By.tagName("span"))
				.above(loginPanel));
		System.out.println(credentials.getText());
		
	}
	
	@Test
	public void testListOfElements() {
		List<WebElement> allSocialMedia = driver.findElements(with(
				By.tagName("img"))
				.near(By.id("footer")));
		
		for(WebElement socialMedia: allSocialMedia) {
			System.out.println(socialMedia.getAttribute("alt"));
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
