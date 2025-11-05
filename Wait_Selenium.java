package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait_Selenium {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the "Add Element" button and click it
            WebElement addButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Element']")));
            addButton.click();
            System.out.println("Clicked 'Add Element' button.");

            // Wait for the "Delete" button and click it
            WebElement deleteButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete']")));
            deleteButton.click();
            System.out.println("Clicked 'Delete' button.");

        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
