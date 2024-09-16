package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormRadioBtnVariant23LabelTest extends BaseTest {
    @Test(testName = "Check if radio button variant 2.3 label on form page has valid text")
    public void testRadioBtnVariant23LabelTest() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getRadioBtn23Text(), "Вариант 2.3");
    }
}
