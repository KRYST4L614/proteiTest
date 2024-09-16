package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormCheckBoxVariant12LabelTest extends BaseTest {
    @Test(testName = "Check if checkbox variant 1.2 label on form page has valid text")
    public void testCheckBoxVariant12Label() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getCheckBox12Text(), "Вариант 1.2");
    }
}