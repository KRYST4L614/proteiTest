package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Не проходит 4 теста из 6 из-за бага, связанного с некорректной валидацией email адресов, написал об этом
// в баг-репорте в в репозитории
public class FormEmailBadPassTest extends BaseTest {

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
    @Test(testName = "Check if email format error is visible when invalid email",
            dataProvider = "emailProvider")
    public void testEmailFormat(String email) {
        FormPage page = new LoginPage(driver).login();
        String actual = page.fillEmailField(email).addData().getEmailErrorMessage();
        Assert.assertEquals(actual, "Неверный формат E-Mail");
    }
}
