package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormCheckBoxVariant11LabelTest extends BaseTest {
    @Test(testName = "Check if checkbox variant 1.1 label on form page has valid text")
    public void testCheckBoxVariant11Label() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getCheckBox11Text(), "Вариант 1.1");
    }
}
