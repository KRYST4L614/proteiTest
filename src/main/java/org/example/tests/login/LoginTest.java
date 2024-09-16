package org.example.tests.login;

import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Parameters()
    @Test(testName = "Check if user can login with password and email")
    public void loginTest() {
        LoginPage page = new LoginPage(driver);
        page.login();
    }
}
