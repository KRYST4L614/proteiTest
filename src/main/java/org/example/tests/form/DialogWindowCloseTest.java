package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowCloseTest extends BaseTest {
    @Test(testName = "Check if dialog window is closing when click on dialog button")
    public void testDialogWindowIsClosesOnDialogBtnClick() {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField("protei@protei.ru")
                .fillNameField("test")
                .addData()
                .clickOnDialogButton();
        Assert.assertFalse(page.dialogWindowIsVisible());
    }
}
