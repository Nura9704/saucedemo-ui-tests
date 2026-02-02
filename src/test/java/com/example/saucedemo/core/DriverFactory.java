package com.example.saucedemo.core;

import com.example.saucedemo.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver create() {
        String browser = TestConfig.BROWSER.toLowerCase();

        return switch (browser) {
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "chrome" -> new ChromeDriver();
            default -> throw new IllegalArgumentException("Unknown browser: " + browser);
        };
    }
}
