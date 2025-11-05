package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WindowsAuthenticationFirefox {
    public static void main(String[] args) {

        // Set path to geckodriver
        System.setProperty("webdriver.gecko.driver",
                "C:\\Selenium_data\\geckodriver-v0.34.0-win64\\geckodriver.exe");

        // Create Firefox profile
        FirefoxProfile profile = new FirefoxProfile();

        // Base URL for trusted sites
        String trustedURIs = "http://httpbin.org";

        // Set NTLM/Windows authentication for trusted URIs (optional for basic auth)
        profile.setPreference("network.automatic-ntlm-auth.trusted-uris", trustedURIs);
        profile.setPreference("network.negotiate-auth.trusted-uris", trustedURIs);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        // Declare driver outside the try block
        WebDriver driver = null;

        try {
            // Initialize Firefox driver
            driver = new FirefoxDriver(options);

            // Navigate to test URL (httpbin.org basic auth)
            // Format: http://username:password@hostname
            driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");

            System.out.println("Firefox opened and authenticated successfully.");

        } finally {
            // Close browser safely
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
