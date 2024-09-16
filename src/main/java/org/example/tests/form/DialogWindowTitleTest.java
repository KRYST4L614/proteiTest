package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowTitleTest extends BaseTest {
    @Test(testName = "Check if dialog window title has valid text")
    public void testDialogWindowTitle() {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField("protei@protei.ru")
                .fillNameField("test")
                .addData();
        Assert.assertEquals(page.getDialogWindowTitle(), "Данные добавлены.");
    }
}
