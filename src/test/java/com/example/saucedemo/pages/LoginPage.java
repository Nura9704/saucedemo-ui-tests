package com.example.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorBox = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String value) {
        waits.visible(username);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(value);
        return this;
    }

    public LoginPage typePassword(String value) {
        waits.visible(password);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public void clickLogin() {
        waits.clickable(loginBtn);
        driver.findElement(loginBtn).click();
    }

    public String getErrorText() {
        waits.visible(errorBox);
        return driver.findElement(errorBox).getText();
    }
}
