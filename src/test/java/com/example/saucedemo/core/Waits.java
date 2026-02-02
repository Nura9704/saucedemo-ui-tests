package com.example.saucedemo.core;

import com.example.saucedemo.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private final WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.wait = new WebDriverWait(driver, TestConfig.TIMEOUT);
    }

    public void visible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void urlContains(String part) {
        wait.until(ExpectedConditions.urlContains(part));
    }
}
