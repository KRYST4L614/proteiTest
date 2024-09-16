package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormRadioBtnVariant22LabelTest extends BaseTest {
    @Test(testName = "Check if radio button variant 2.2 label on form page has valid text")
    public void testRadioBtnVariant22LabelTest() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getRadioBtn22Text(), "Вариант 2.2");
    }
}