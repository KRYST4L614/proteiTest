package org.example.tests.form;

import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTableHeaderTest extends BaseTest {
    @Test(testName = "Check if table headers on form page has valid text")
    public void formTableHeaderTest() {
        String actual = new LoginPage(driver).login().getHeadersFromDataTable();
        Assert.assertEquals(actual, "E-Mail Имя Пол Выбор 1 Выбор 2");
    }
}
