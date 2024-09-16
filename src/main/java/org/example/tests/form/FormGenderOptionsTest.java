package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

public class FormGenderOptionsTest extends BaseTest {
    @Test(testName = "Check if gender options on form page has valid text")
    public void testGenderOptions() {
        FormPage page = new LoginPage(driver).login();
        List<String> expected = Stream.of(
                FormPage.Gender.MAN.getLabel(),
                FormPage.Gender.WOMAN.getLabel()
        ).toList();

        Assert.assertEquals(page.getGenderOptions(), expected);
    }
}
