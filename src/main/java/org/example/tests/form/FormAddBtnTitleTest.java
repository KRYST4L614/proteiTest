package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAddBtnTitleTest extends BaseTest {
    @Test(testName = "Check if add data button title on form page has valid text")
    public void testAddButtonTitle() {
        FormPage page = new LoginPage(driver).login();
        Assert.assertEquals(page.getAddDataButtonTitle(), "Добавить");
    }
}
