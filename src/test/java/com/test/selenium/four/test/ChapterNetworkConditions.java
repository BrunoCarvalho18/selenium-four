package com.test.selenium.four.test;

import java.util.Optional;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v93.network.Network;
import org.openqa.selenium.devtools.v93.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChapterNetworkConditions {
	
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		devTools = driver.getDevTools();
	}
	
	@Test
    public void enableSlowRexJones() {
		devTools.createSession();
		devTools.send(Network.enable(
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(
				false,
				150, 
				2500, 
				2000, 
				Optional.of(ConnectionType.CELLULAR3G)));
		
		driver.get("https://RexJones2.com");
		
		System.out.println("Enable Slow Network: " + driver.getTitle());
    }
	
	@Test
	public void doNotEnableRexJones() {
		driver.get("https://RexJones2.com");
		System.out.println("Do Not Enable Network: " + driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
