package com.epam.seleniumwebdriver.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class FirefoxFactory extends DriverFactory<FirefoxOptions> {

    private static FirefoxFactory instance;
    private WebDriver driver;

    private FirefoxFactory() {}

    public static synchronized FirefoxFactory getInstance() {
        if (instance == null) {
            instance = new FirefoxFactory();
        }
        return instance;
    }

    @Override
    protected WebDriver createLocalDriver(FirefoxOptions options) {
        if (driver == null) {
            driver = new FirefoxDriver(options);
        }
        return driver;
    }

    @Override
    protected FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        options.addArguments("no-sandbox");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-default-apps");
        options.addArguments("disable-extensions-file-access-check");
        options.addArguments("disable-search-engine-choice-screen");
        options.addArguments("-private");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    public WebDriver getDriver() {
        return createLocalDriver(getOptions());
    }
}
