package com.epam.seleniumwebdriver.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeFactory extends DriverFactory<ChromeOptions> {

    private static ChromeFactory instance;
    private WebDriver driver;

    private ChromeFactory() {}

    public static synchronized ChromeFactory getInstance() {
        if (instance == null) {
            instance = new ChromeFactory();
        }
        return instance;
    }

    @Override
    protected WebDriver createLocalDriver(ChromeOptions options) {
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    @Override
    protected ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("no-sandbox");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-default-apps");
        options.addArguments("disable-extensions-file-access-check");
        options.addArguments("disable-search-engine-choice-screen");
        options.addArguments("incognito");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    public WebDriver getDriver() {
        return createLocalDriver(getOptions());
    }
}
