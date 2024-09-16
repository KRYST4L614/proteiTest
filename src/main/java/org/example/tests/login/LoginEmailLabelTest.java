package org.example.tests.login;


import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginEmailLabelTest extends BaseTest {
    @Test(testName = "Check if login label on login page has valid text")
    public void testEmailLabel() {
        LoginPage page = new LoginPage(driver);
        Assert.assertEquals(page.getEmailLabel(), "E-Mail:");
    }
}
