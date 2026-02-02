package com.example.saucedemo.tests;

import com.example.saucedemo.pages.InventoryPage;
import com.example.saucedemo.pages.LoginPage;
import com.example.saucedemo.core.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    private LoginPage loginPage() {
        return new LoginPage(DriverManager.getDriver());
    }

    private InventoryPage inventoryPage() {
        return new InventoryPage(DriverManager.getDriver());
    }

    @Step("Войти пользователем: {username}")
    private void login(String username, String password) {
        loginPage()
                .typeUsername(username)
                .typePassword(password)
                .clickLogin();
    }

    @Test
    @DisplayName("Успешный логин: standard_user / secret_sauce")
    @Description("Проверяем, что после логина открывается Inventory page.")
    void successfulLogin() {
        login("standard_user", "secret_sauce");

        Assertions.assertTrue(inventoryPage().isOpened(), "Inventory page should be opened");
        Assertions.assertEquals("Products", inventoryPage().getTitleText());
    }

    @Test
    @DisplayName("Логин с неверным паролем")
    @Description("Проверяем сообщение об ошибке при неверном пароле.")
    void loginWithWrongPassword() {
        login("standard_user", "wrong_password");

        String error = loginPage().getErrorText();
        Assertions.assertTrue(error.toLowerCase().contains("username and password do not match"),
                "Error should mention mismatch username/password");
    }

    @Test
    @DisplayName("Логин заблокированного пользователя: locked_out_user")
    @Description("Проверяем, что появляется сообщение о блокировке.")
    void lockedOutUserLogin() {
        login("locked_out_user", "secret_sauce");

        String error = loginPage().getErrorText();
        Assertions.assertTrue(error.toLowerCase().contains("locked out"),
                "Error should mention locked out user");
    }

    @Test
    @DisplayName("Логин с пустыми полями")
    @Description("Проверяем, что появляется сообщение о необходимости ввода данных.")
    void loginWithEmptyFields() {
        loginPage().clickLogin();

        String error = loginPage().getErrorText();
        Assertions.assertTrue(error.toLowerCase().contains("username is required"),
                "Error should mention username required");
    }

    @Test
    @DisplayName("Логин performance_glitch_user (страница открывается несмотря на задержки)")
    @Description("Проверяем успешный переход на Inventory page даже при возможных задержках.")
    void performanceGlitchUserLogin() {
        login("performance_glitch_user", "secret_sauce");

        // В этом тесте важны ожидания. Мы уже используем waits.urlContains + waits.visible в InventoryPage.
        Assertions.assertTrue(inventoryPage().isOpened(), "Inventory page should be opened for performance_glitch_user");
    }
}
