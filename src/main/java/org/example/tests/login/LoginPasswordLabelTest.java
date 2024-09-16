package org.example.tests.login;


import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPasswordLabelTest extends BaseTest {
    @Test(testName = "Check if password label on login page has valid text")
    public void testPasswordLabel() {
        LoginPage page = new LoginPage(driver);
        Assert.assertEquals(page.getPasswordLabel(), "Пароль:");
    }
}
