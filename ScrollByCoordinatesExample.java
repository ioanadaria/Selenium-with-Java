package com.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollByCoordinatesExample {

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

            // Scroll down by 500 pixels
            js.executeScript("window.scrollBy(0, 500);");
            System.out.println("Scrolled down by 500 pixels.");
            Thread.sleep(2000);

            // Scroll down by another 700 pixels
            js.executeScript("window.scrollBy(0, 700);");
            System.out.println("Scrolled down by 700 pixels.");
            Thread.sleep(2000);

            // Scroll up by 400 pixels
            js.executeScript("window.scrollBy(0, -400);");
            System.out.println("Scrolled up by 400 pixels.");
            Thread.sleep(2000);

            // Scroll left by 100 pixels (if horizontal scroll exists)
            js.executeScript("window.scrollBy(-100, 0);");
            System.out.println("Scrolled left by 100 pixels.");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

