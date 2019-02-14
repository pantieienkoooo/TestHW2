package com.company.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.company.Common.Constans.BASE_URL;

public class DriverFactory {
    public static WebDriver getDriver() {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", ".idea/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return driver;
    }
}
