package org.example.tests.login;

import org.example.core.pages.LoginPage;
import org.example.core.valueObjects.User;
import org.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Не проходит 4 теста из 6 из-за бага, связанного с некорректной валидацией email адресов, написал об этом
// в баг-репорте в в репозитории
public class LoginBadPassTest extends BaseTest {

    @DataProvider(name = "userProvider")
    public User[] usersProvider() {
        return new User[]{
                new User("protei@protei.ru", "test"),
                new User("test@protei.ru", "protei"),
                new User("test@protei.ru", "")
        };
    }


    @Test(testName = "Check if user cannot login with invalid password or/and email",
            dataProvider = "userProvider")
    public void loginBadPassTest(User user) {
        LoginPage page = new LoginPage(driver);
        String actual = page
                .fillEmailField(user.email())
                .fillPasswordField(user.password())
                .clickOnLogin()
                .getInvalidEmailPasswordMessage();
        Assert.assertEquals(actual, "Неверный E-Mail или пароль");
    }
}
