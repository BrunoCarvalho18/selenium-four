package com.test.selenium.four.test;


import java.util.Optional;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.emulation.Emulation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterGeolocation {
	
	ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void mockGeoLeocation() {
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(32.746940),Optional.of(-97.092400), Optional.of(1)));
		driver.get("https://where-am-i.org/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
