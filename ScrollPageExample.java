package com.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPageExample {

    public static void main(String[] args) throws InterruptedException {

        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the sample page
        driver.get("https://the-internet.herokuapp.com/large");

        try {
            // Cast WebDriver to JavaScriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll to the bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            System.out.println("Scrolled to the bottom of the page.");

            // Optional: wait a few seconds to see the result
            Thread.sleep(3000);

            // Scroll back to the top
            js.executeScript("window.scrollTo(0, 0);");
            System.out.println("Scrolled back to the top of the page.");

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

