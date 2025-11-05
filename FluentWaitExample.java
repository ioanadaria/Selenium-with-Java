package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        try {
            // Click the Remove button
            driver.findElement(By.xpath("//button[text()='Remove']")).click();
            System.out.println("Clicked on Remove button.");

            // Create a FluentWait instance
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))          // Max 15 seconds
                    .pollingEvery(Duration.ofSeconds(1))          // Check every 1 second
                    .ignoring(NoSuchElementException.class);      // Ignore missing element errors

            // Wait for the message to appear
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            System.out.println("Message displayed: " + message.getText());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

