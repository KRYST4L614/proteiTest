package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowVisibleTest extends BaseTest {
    @Test(testName = "Check if dialog window is visible when data is added")
    public void testDialogWindowIsVisibleOnDataAdding() {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField("protei@protei.ru")
                .fillNameField("test")
                .addData();
        Assert.assertTrue(page.dialogWindowIsVisible());
    }
}
