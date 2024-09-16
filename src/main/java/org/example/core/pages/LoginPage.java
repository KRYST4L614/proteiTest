package org.example.core.pages;

import org.example.core.valueObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    public static final User user = new User("test@protei.ru", "test");
    private static final By emailLabel = By.cssSelector("label[for='loginEmail']");
    private static final By passwordLabel = By.cssSelector("label[for='loginPassword']");
    private static final By emailInput = By.cssSelector("input[id='loginEmail']");
    private static final By passwordInput = By.cssSelector("input[id='loginPassword']");
    private static final By loginButton = By.id("authButton");
    private static final By emailFormatError = By.id("emailFormatError");
    private static final By invalidEmailPassword = By.id("invalidEmailPassword");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        checkPage();
    }

    @Override
    public void checkPage() {
        Assert.assertTrue(driver.findElement(emailLabel).isDisplayed(), "Email label must be visible");
        Assert.assertTrue(driver.findElement(passwordLabel).isDisplayed(), "Password label must be visible");
        Assert.assertTrue(driver.findElement(emailInput).isDisplayed(), "Email input must be visible");
        Assert.assertTrue(driver.findElement(passwordInput).isDisplayed(), "Password input must be visible");
    }

    public String getEmailLabel() {
        return driver.findElement(emailLabel).getText();
    }

    public String getPasswordLabel() {
        return driver.findElement(passwordLabel).getText();
    }

    public LoginPage fillEmailField(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public String getEmailFormatErrorMessage() {
        return driver.findElement(emailFormatError).getText();
    }

    public String getInvalidEmailPasswordMessage() {
        return driver.findElement(invalidEmailPassword).getText();
    }

    public String getLoginButtonTitle() {
        return driver.findElement(loginButton).getText();
    }

    public FormPage login() {
        fillPasswordField(user.password());
        fillEmailField(user.email());
        clickOnLogin();
        return new FormPage(driver);
    }

    public LoginPage clickOnLogin() {
        driver.findElement(loginButton).click();
        return this;
    }
}