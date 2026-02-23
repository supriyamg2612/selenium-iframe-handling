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

public class NestedFrameDemo {
	
	static WebDriver driver ;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		 List<WebElement> frames = driver.findElements(By.tagName("frame"));
         System.out.println("Total frames on page: " + frames.size());
         
         
         // ✅ Step 1: Switch to Frame 3 (index 2
         
         myWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
         System.out.println("Switched to Frame 3");
         
      // ✅ Step 2: Enter text in Frame 3 input

         driver.findElement(By.name("mytext3")).sendKeys("Handling Nested Frames");
         
      // ✅ Step 3: Find nested iframe inside Frame 3

         driver.switchTo().frame(0);

         System.out.println("Switched to Nested Frame");
         driver.findElement(By.xpath("//div[@role='radio']")).click();
         driver.switchTo().parentFrame();
         System.out.println("Back to Frame 3");
         
         driver.switchTo().defaultContent();
         System.out.println("Back to Main Page");
         driver.quit();
         
         

         
         

}
}