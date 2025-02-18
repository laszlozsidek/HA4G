package com.zsidek.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver instance = null;

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = new ChromeDriver();
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return instance;
    }
}
