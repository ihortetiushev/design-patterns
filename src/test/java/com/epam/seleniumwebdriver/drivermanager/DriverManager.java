package com.epam.seleniumwebdriver.drivermanager;

import com.epam.seleniumwebdriver.core.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager {
    private static WebDriver driver;

    private static void createDriver() {
        if (driver != null) return;

        String driverType = ConfigReader.get("driver");
        switch (driverType) {
            case "Edge":
                driver = EdgeFactory.getInstance().getDriver();
                break;
            case "Chrome":
                driver = ChromeFactory.getInstance().getDriver();
                break;
            case "Firefox":
                driver = FirefoxFactory.getInstance().getDriver();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Driver type %s is not supported", driverType)
                );
        }
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            createDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
