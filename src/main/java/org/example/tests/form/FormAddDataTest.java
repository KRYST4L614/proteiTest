package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.core.valueObjects.DataTableItem;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormAddDataTest extends BaseTest {

    @DataProvider(name = "itemsProvider")
    public DataTableItem[] usersProvider() {
        return new DataTableItem[]{
                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.WOMAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_2, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1_AND_1_2, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_2),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_3),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_NOT_CHOOSE, FormPage.RadioButtonVariant.VARIANT_2_3),

                new DataTableItem("protei@protei.ru", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_NOT_CHOOSE),
        };
    }

    @Test(testName = "Check if data is adding",
            dataProvider = "itemsProvider")
    public void testAddData(DataTableItem item) {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField(item.email())
                .fillNameField(item.name())
                .chooseGender(item.gender())
                .chooseCheckBox(item.checkBoxVariant())
                .chooseRadioButton(item.radioButtonVariant())
                .addData()
                .clickOnDialogButton()
                .addData();

        for (String actual : page.getDataTable()) {
            Assert.assertEquals(actual, item.toString());
        }
    }
}
