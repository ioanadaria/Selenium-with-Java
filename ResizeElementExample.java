package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeElementExample {

    public static void main(String[] args) throws InterruptedException {

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the resizable demo page
        driver.get("https://jqueryui.com/resizable/");

        try {
            // The resizable demo is inside an iframe, so switch to it
            driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

            // Find the resizable element (the box)
            WebElement resizableBox = driver.findElement(By.id("resizable"));

            // Find the resize handle (bottom-right corner)
            WebElement resizeHandle = resizableBox.findElement(By.cssSelector(".ui-resizable-se"));

            // Use Actions class to resize
            Actions actions = new Actions(driver);

            // Resize by 100 pixels width and 50 pixels height
            actions.clickAndHold(resizeHandle)
                    .moveByOffset(100, 50)
                    .release()
                    .perform();

            System.out.println("Element resized successfully!");

            // Optional: wait a few seconds to see the result
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

