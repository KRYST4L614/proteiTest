package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormEmailLabelTest extends BaseTest {
    @Test(testName = "Check if email label on form page has valid text")
    public void testEmailLabel() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getEmailLabelText(), "E-Mail:");
    }
}
