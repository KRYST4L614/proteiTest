package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormGenderLabelTest extends BaseTest {
    @Test(testName = "Check if gender label on form page has valid text")
    public void testGenderLabel() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getGenderLabelText(), "Пол:");
    }
}
