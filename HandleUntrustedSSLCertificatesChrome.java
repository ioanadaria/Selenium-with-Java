package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleUntrustedSSLCertificatesChrome {

    public static void main(String[] args) {

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Selenium_data\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Accept untrusted SSL certificates
        options.setAcceptInsecureCerts(true);

        // Merge capabilities (for backward compatibility)
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.merge(capabilities);

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a site with an invalid SSL certificate
        driver.get("https://expired.badssl.com/");

        // Verify SSL handling by checking page title
        String title = driver.getTitle();
        System.out.println("✅ Page Title: " + title);

        // Check if SSL cert acceptance was enabled in capabilities
        boolean isInsecureCertsAccepted = (boolean)
                ((ChromeDriver) driver).getCapabilities().getCapability(CapabilityType.ACCEPT_INSECURE_CERTS);

        if (isInsecureCertsAccepted) {
            System.out.println("✅ Chrome is configured to accept insecure certificates.");
        } else {
            System.out.println("❌ Chrome is NOT configured to accept insecure certificates.");
        }

        // Close browser
        driver.quit();
    }
}
