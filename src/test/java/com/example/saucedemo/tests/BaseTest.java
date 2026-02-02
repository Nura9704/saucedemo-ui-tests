package com.example.saucedemo.tests;

import com.example.saucedemo.config.TestConfig;
import com.example.saucedemo.core.DriverFactory;
import com.example.saucedemo.core.DriverManager;
import com.example.saucedemo.utils.AllureAttachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @BeforeEach
    void setUp(TestInfo testInfo) {
        log.info("START test: {}", testInfo.getDisplayName());

        var driver = DriverFactory.create();
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(TestConfig.BASE_URL);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        var driver = DriverManager.getDriver();
        try {
            // На всякий случай всегда прикладываем артефакты (проще для новичка)
            if (driver != null) {
                AllureAttachments.screenshot(driver);
                AllureAttachments.pageSource(driver);
            }
        } catch (Exception e) {
            log.warn("Failed to attach artifacts: {}", e.getMessage());
        } finally {
            DriverManager.quitDriver();
        }

        log.info("END test: {}", testInfo.getDisplayName());
    }
}
