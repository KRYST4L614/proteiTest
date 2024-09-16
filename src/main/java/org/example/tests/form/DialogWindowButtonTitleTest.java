package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowButtonTitleTest extends BaseTest {
    @Test(testName = "Check if dialog window button has valid text")
    public void testDialogWindowIsVisibleOnDataAdding() {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField("protei@protei.ru")
                .fillNameField("test")
                .addData();
        Assert.assertEquals(page.getDialogWindowButtonTitle(), "Ok");
    }
}
