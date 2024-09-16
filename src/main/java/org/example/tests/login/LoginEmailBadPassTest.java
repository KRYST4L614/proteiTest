package org.example.tests.login;

import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Не проходит 4 теста из 6 из-за бага, связанного с некорректной валидацией email адресов, написал об этом
// в баг-репорте в в репозитории
public class LoginEmailBadPassTest extends BaseTest {

    @DataProvider(name = "emailProvider")
    public static String[] emailProvider() {
        return new String[]{
                "",
                "   ",
                "123@mag@gmail.com",
                "a@b.c",
                "abc+def@gmail.com",
                "info@gmail",
                "@gmail.com"
        };
    }

    @Test(testName = "Check if user cannot login with invalid email",
            dataProvider = "emailProvider")
    public void loginBadPassTest(String email) {
        LoginPage page = new LoginPage(driver);
        String actual = page
                .fillEmailField(email)
                .fillPasswordField(LoginPage.user.password())
                .clickOnLogin()
                .getEmailFormatErrorMessage();
        Assert.assertEquals(actual, "Неверный формат E-Mail");
    }
}

