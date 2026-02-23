package com.selenium.iframehandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleIframeDemo {
	
	static WebDriver driver ;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		 List<WebElement> frames = driver.findElements(By.tagName("frame"));
         System.out.println("Total frames on page: " + frames.size());

		
         
         
         myWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
         System.out.println("Switched to Frame 1");
		
         driver.findElement(By.name("mytext1")).sendKeys("Hello Selenium Frame Handling");
         
         driver.switchTo().defaultContent();
         System.out.println("Back to main page");
         
         
		
}
}