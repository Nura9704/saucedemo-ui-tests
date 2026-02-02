package com.example.saucedemo.config;

import java.time.Duration;

public class TestConfig {
    public static final String BASE_URL = System.getProperty("baseUrl", "https://www.saucedemo.com/");
    public static final String BROWSER  = System.getProperty("browser", "chrome"); // chrome|firefox|edge
    public static final Duration TIMEOUT = Duration.ofSeconds(Long.parseLong(System.getProperty("timeoutSec", "10")));
}
