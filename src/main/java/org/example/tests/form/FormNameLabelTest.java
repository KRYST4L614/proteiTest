package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormNameLabelTest extends BaseTest {
    @Test(testName = "Check if name label on form page has valid text")
    public void testNameLabel() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getNameLabelText(), "Имя:");
    }
}
