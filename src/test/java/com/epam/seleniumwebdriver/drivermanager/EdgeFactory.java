package com.epam.seleniumwebdriver.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class EdgeFactory extends DriverFactory<EdgeOptions> {

    private static EdgeFactory instance;
    private WebDriver driver;

    private EdgeFactory() {}

    public static synchronized EdgeFactory getInstance() {
        if (instance == null) {
            instance = new EdgeFactory();
        }
        return instance;
    }

    @Override
    protected WebDriver createLocalDriver(EdgeOptions options) {
        if (driver == null) {
            driver = new EdgeDriver(options);
        }
        return driver;
    }

    @Override
    protected EdgeOptions getOptions() {
        EdgeOptions options = new EdgeOptions();
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
