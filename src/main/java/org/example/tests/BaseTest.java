package org.example.tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public abstract class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeMethod
    protected void setup() throws MalformedURLException, URISyntaxException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1920, 1080");
        driver = new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("file:///dev/test/qa-test.html");
    }

    @AfterMethod
    protected void cleanup() {
        driver.quit();
    }
}
