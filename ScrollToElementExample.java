package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollToElementExample {

    public static void main(String[] args) throws InterruptedException {

        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open sample page
        driver.get("https://the-internet.herokuapp.com/large");

        try {
            // Find the target element (for example, row 50 in the table)
            WebElement targetElement = driver.findElement(By.xpath("//table/tbody/tr[50]/td[1]"));

            // Scroll the element into view using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
            System.out.println("Scrolled to the target element: " + targetElement.getText());

            // Optional: highlight element or wait a bit to see it
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
