package com.test.selenium.four.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterConsoleLogs {
	
	ChromeDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void viewBrowserConsoleLogs() {
		//Get the DevTools & Create A Session
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Enable The Console Logs
		devTools.send(Log.enable());
		
		// Add A Listener For the Console Logs
		devTools.addListener(Log.entryAdded(), logEntry->{
			System.out.println("------");
		    System.out.println("Text: "+ logEntry.getText());
		    System.out.println("Level: " + logEntry.getLevel());
		    System.out.println("Level: " + logEntry.getUrl());
		});
		
        //Load the AUT
		
		driver.get("http://the-internet.herokuapp.com/broken_images");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
