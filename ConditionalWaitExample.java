package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConditionalWaitExample {

    public static void main(String[] args) {

        // Set path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open demo page with dynamic content
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        try {
            // Create an explicit wait (max 10 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click the Start button
            WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
            startButton.click();
            System.out.println("Clicked on Start button... waiting for content to load.");

            // Wait for the "Hello World!" text to appear
            WebElement helloText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4"))
            );

            // Print the text once visible
            System.out.println("Text appeared: " + helloText.getText());

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

