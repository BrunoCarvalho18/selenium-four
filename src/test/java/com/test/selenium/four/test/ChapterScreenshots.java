package com.test.selenium.four.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterScreenshots {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://applitools.com/");
	}
	
	@Test
	public void takeWebElementScreenshot() throws IOException {
		WebElement nextGenerationPlatform = driver.findElement(
				By.cssSelector("#post-8 h1"));
				
		
		File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
		File destination = new File("Next Generation Platform.png");
		FileHandler.copy(source, destination);
		
	}
	
	@Test
	public void takeWebElementPageSectionScreenshot() throws IOException {
		WebElement apptoolsPageSection = driver.findElement(
				By.cssSelector("#post-8>header"));
		
		File source = apptoolsPageSection.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("Applitools Page Section.png"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
