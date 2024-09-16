package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormBlankNameErrorTest extends BaseTest {
    @Test(testName = "Check if blank name error is visible when name field is blank")
    public void blankNameErrorTest() {
        FormPage page = new LoginPage(driver).login();
        String actual = page
                .fillEmailField("protei@test.ru")
                .addData()
                .getBlankNameErrorMessage();

        Assert.assertEquals(actual, "Поле имя не может быть пустым");
    }
}
