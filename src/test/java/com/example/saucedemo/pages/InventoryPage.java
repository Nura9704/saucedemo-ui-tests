package com.example.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By title = By.cssSelector("[data-test='title']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        // Страница инвентаря обычно /inventory.html
        waits.urlContains("inventory.html");
        waits.visible(title);
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        waits.visible(title);
        return driver.findElement(title).getText();
    }
}
