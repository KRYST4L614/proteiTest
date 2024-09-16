package org.example.tests.login;

import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginButtonTitleTest extends BaseTest {
    @Test(testName = "Check if login button on login page has valid text")
    public void testLoginButtonTitle() {
        LoginPage page = new LoginPage(driver);
        Assert.assertEquals(page.getLoginButtonTitle(), "Вход");
    }
}
