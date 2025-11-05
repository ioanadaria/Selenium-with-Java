package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandleUntrustedSSLCertificatesFirefox {

    public static void main(String[] args) {

        // Set path to GeckoDriver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Selenium_data\\geckodriver-v0.34.0-win64\\geckodriver.exe");

        // Create FirefoxOptions instance
        FirefoxOptions options = new FirefoxOptions();

        // Accept untrusted certificates
        options.setAcceptInsecureCerts(true);

        // Initialize WebDriver with the configured options
        WebDriver driver = new FirefoxDriver(options);

        // Navigate to an example site with an expired SSL certificate
        driver.get("https://expired.badssl.com/");

        // Print the title to confirm the page loaded successfully
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
