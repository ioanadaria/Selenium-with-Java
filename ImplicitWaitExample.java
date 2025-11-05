package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set an implicit wait for all elements (10 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        try {
            // Click the Remove button
            WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
            removeButton.click();
            System.out.println("Clicked on Remove button.");

            // Find the message that appears after removal
            WebElement message = driver.findElement(By.id("message"));
            System.out.println("Message displayed: " + message.getText());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

