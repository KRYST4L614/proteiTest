package org.example.core.pages;

import org.example.core.valueObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    public static final User USER = new User("test@protei.ru", "test");
    private static final By EMAIL_LABEL = By.cssSelector("label[for='loginEmail']");
    private static final By PASSWORD_LABEL = By.cssSelector("label[for='loginPassword']");
    private static final By EMAIL_INPUT = By.cssSelector("input[id='loginEmail']");
    private static final By PASSWORD_INPUT = By.cssSelector("input[id='loginPassword']");
    private static final By LOGIN_BUTTON = By.id("authButton");
    private static final By EMAIL_FORMAT_ERROR = By.id("emailFormatError");
    private static final By INVALID_EMAIL_PASSWORD = By.id("invalidEmailPassword");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        checkPage();
    }

    @Override
    public void checkPage() {
        Assert.assertTrue(driver.findElement(EMAIL_LABEL).isDisplayed(), "Email label must be visible");
        Assert.assertTrue(driver.findElement(PASSWORD_LABEL).isDisplayed(), "Password label must be visible");
        Assert.assertTrue(driver.findElement(EMAIL_INPUT).isDisplayed(), "Email input must be visible");
        Assert.assertTrue(driver.findElement(PASSWORD_INPUT).isDisplayed(), "Password input must be visible");
    }

    public String getEmailLabel() {
        return driver.findElement(EMAIL_LABEL).getText();
    }

    public String getPasswordLabel() {
        return driver.findElement(PASSWORD_LABEL).getText();
    }

    public LoginPage fillEmailField(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public String getEmailFormatErrorMessage() {
        return driver.findElement(EMAIL_FORMAT_ERROR).getText();
    }

    public String getInvalidEmailPasswordMessage() {
        return driver.findElement(INVALID_EMAIL_PASSWORD).getText();
    }

    public String getLoginButtonTitle() {
        return driver.findElement(LOGIN_BUTTON).getText();
    }

    public FormPage login() {
        fillPasswordField(USER.password());
        fillEmailField(USER.email());
        clickOnLogin();
        return new FormPage(driver);
    }

    public LoginPage clickOnLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
}