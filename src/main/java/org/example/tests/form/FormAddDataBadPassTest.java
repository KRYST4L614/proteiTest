package org.example.tests.form;

import org.example.core.pages.FormPage;
import org.example.core.pages.LoginPage;
import org.example.core.valueObjects.DataTableItem;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Не проходит 4 теста из 6 из-за бага, связанного с некорректной валидацией email адресов, написал об этом
// в баг-репорте в в репозитории
public class FormAddDataBadPassTest extends BaseTest {

    @DataProvider(name = "itemsProvider")
    public DataTableItem[] usersProvider() {
        return new DataTableItem[]{
                new DataTableItem("", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("   ", "test", FormPage.Gender.WOMAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("123@mag@gmail.com", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_2, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("a@b.c", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1_AND_1_2, FormPage.RadioButtonVariant.VARIANT_2_1),

                new DataTableItem("abc+def@gmail.com", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_2),

                new DataTableItem("info@gmail", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_3),

                new DataTableItem("@gmail.com", "test", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_NOT_CHOOSE, FormPage.RadioButtonVariant.VARIANT_2_3),

                new DataTableItem("protei@protei.ru", "", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_3),

                new DataTableItem("protei@protei.ru", "   ", FormPage.Gender.MAN,
                        FormPage.CheckBoxVariant.VARIANT_1_1, FormPage.RadioButtonVariant.VARIANT_2_3),
        };
    }

    @Test(testName = "Check if data is not adding if data is invalid",
            dataProvider = "itemsProvider")
    public void testAddDataBadPass(DataTableItem item) {
        FormPage page = new LoginPage(driver).login();

        page
                .fillEmailField(item.email())
                .fillNameField(item.name())
                .chooseGender(item.gender())
                .chooseCheckBox(item.checkBoxVariant())
                .chooseRadioButton(item.radioButtonVariant())
                .addData();

        Assert.assertEquals(page.getDataTable().size(), 0);
    }
}
