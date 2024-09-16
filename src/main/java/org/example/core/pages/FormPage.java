package org.example.core.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class FormPage extends BasePage {

    private final WebDriver driver;
    private static final By EMAIL_LABEL = By.cssSelector("label[for='dataEmail']");
    private static final By NAME_LABEL = By.cssSelector("label[for='dataName']");
    private static final By GENDER_LABEL = By.cssSelector("label[for='dataGender']");
    private static final By EMAIL_INPUT = By.cssSelector("input[id='dataEmail']");
    private static final By NAME_INPUT = By.cssSelector("input[id='dataName']");
    private static final By GENDER_SELECTOR = By.cssSelector("select[id='dataGender']");
    private static final By CHECK_BOX_1_1 = By.cssSelector("input[id='dataCheck11']");
    private static final By CHECK_BOX_1_1_LABEL = By.xpath("//input[@id='dataCheck11']/..");
    private static final By CHECK_BOX_1_2 = By.cssSelector("input[id='dataCheck12']");
    private static final By CHECK_BOX_1_2_LABEL = By.xpath("//input[@id='dataCheck12']/..");
    private static final By RADIO_BUTTON_2_1 = By.cssSelector("input[id='dataSelect21']");
    private static final By RADIO_BUTTON_2_1_LABEL = By.xpath("//input[@id='dataSelect21']/..");
    private static final By RADIO_BUTTON_2_2 = By.cssSelector("input[id='dataSelect22']");
    private static final By RADIO_BUTTON_2_2_LABEL = By.xpath("//input[@id='dataSelect22']/..");
    private static final By RADIO_BUTTON_2_3 = By.cssSelector("input[id='dataSelect23']");
    private static final By RADIO_BUTTON_2_3_LABEL = By.xpath("//input[@id='dataSelect23']/..");
    private static final By ADD_BUTTON = By.cssSelector("button[id='dataSend']");
    private static final By DATA_TABLE = By.cssSelector("table[id='dataTable']");
    private static final By DIALOG = By.className("uk-modal-dialog");
    private static final By DIALOG_TITLE = By.className("uk-modal-content");
    private static final By DIALOG_BUTTON = By.className("uk-modal-close");
    private static final By EMAIL_ERROR = By.id("emailFormatError");
    private static final By BLANK_NAME_ERROR = By.id("blankNameError");
    private static final Pattern NOT_EMPTY_STRING_REGEX = Pattern.compile(".+");

    public enum CheckBoxVariant {
        VARIANT_1_1("1.1"),
        VARIANT_1_2("1.2"),
        VARIANT_1_1_AND_1_2("1.1, 1.2"),
        VARIANT_NOT_CHOOSE("Нет");

        CheckBoxVariant(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private final String label;
    }

    public enum RadioButtonVariant {
        VARIANT_2_1("2.1"),
        VARIANT_2_2("2.2"),
        VARIANT_2_3("2.3"),
        VARIANT_NOT_CHOOSE("");

        RadioButtonVariant(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private final String label;
    }

    public enum Gender {
        MAN("Мужской"),
        WOMAN("Женский");

        Gender(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private final String label;
    }

    public FormPage(WebDriver driver) {
        this.driver = driver;
        checkPage();
    }

    public String getHeadersFromDataTable() {
        return driver
                .findElement(DATA_TABLE)
                .findElements(By.xpath("./thead/tr"))
                .getFirst()
                .getText();
    }

    public List<String> getDataTable() {
        return driver
                .findElement(DATA_TABLE)
                .findElements(By.xpath("./tbody/tr"))
                .stream().map(WebElement::getText).toList();
    }

    public FormPage chooseGender(Gender gender) {
        Select select = new Select(driver.findElement(GENDER_SELECTOR));
        switch (gender) {
            case MAN -> select.selectByVisibleText("Мужской");
            case WOMAN -> select.selectByVisibleText("Женский");
        }
        return this;
    }

    public FormPage chooseCheckBox(CheckBoxVariant checkBoxVariant) {
        return switch (checkBoxVariant) {
            case VARIANT_1_1 -> clickOnElement(CHECK_BOX_1_1);
            case VARIANT_1_2 -> clickOnElement(CHECK_BOX_1_2);
            case VARIANT_1_1_AND_1_2 -> {
                clickOnElement(CHECK_BOX_1_1);
                yield clickOnElement(CHECK_BOX_1_2);
            }
            case VARIANT_NOT_CHOOSE -> this;
        };
    }

    public FormPage chooseRadioButton(RadioButtonVariant radioButtonVariant) {
        By locator = switch (radioButtonVariant) {
            case VARIANT_2_1 -> RADIO_BUTTON_2_1;
            case VARIANT_2_2 -> RADIO_BUTTON_2_2;
            case VARIANT_2_3 -> RADIO_BUTTON_2_3;
            case VARIANT_NOT_CHOOSE -> null;
        };
        if (locator == null) {
            return this;
        }
        return clickOnElement(locator);
    }

    public FormPage fillEmailField(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public FormPage fillNameField(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
        return this;
    }

    public FormPage addData() {
        return clickOnElement(ADD_BUTTON);
    }

    public Boolean dialogWindowIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(DIALOG)));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String getDialogWindowTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.textMatches(DIALOG_TITLE, NOT_EMPTY_STRING_REGEX));
        } catch (TimeoutException ignored) {
        }
        return driver.findElement(DIALOG_TITLE).getText();
    }

    public String getDialogWindowButtonTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(ExpectedConditions.textMatches(DIALOG_BUTTON, NOT_EMPTY_STRING_REGEX));
        } catch (TimeoutException ignored) {
        }
        return driver.findElement(DIALOG_BUTTON).getText();
    }

    public FormPage clickOnDialogButton() {
        return clickOnElement(DIALOG_BUTTON);
    }

    public String getEmailErrorMessage() {
        return getElementText(EMAIL_ERROR);
    }

    public String getBlankNameErrorMessage() {
        return getElementText(BLANK_NAME_ERROR);
    }

    public String getEmailLabelText() {
        return getElementText(EMAIL_LABEL);
    }

    public String getNameLabelText() {
        return getElementText(NAME_LABEL);
    }

    public String getGenderLabelText() {
        return getElementText(GENDER_LABEL);
    }

    public List<String> getGenderOptions() {
        Select select = new Select(driver.findElement(GENDER_SELECTOR));
        return select.getOptions().stream().map(WebElement::getText).toList();
    }

    public String getCheckBox11Text() {
        return getElementText(CHECK_BOX_1_1_LABEL);
    }

    public String getCheckBox12Text() {
        return getElementText(CHECK_BOX_1_2_LABEL);
    }

    public String getRadioBtn21Text() {
        return getElementText(RADIO_BUTTON_2_1_LABEL);
    }

    public String getRadioBtn22Text() {
        return getElementText(RADIO_BUTTON_2_2_LABEL);
    }

    public String getRadioBtn23Text() {
        return getElementText(RADIO_BUTTON_2_3_LABEL);
    }

    public String getAddDataButtonTitle() {
        return getElementText(ADD_BUTTON);
    }

    @Override
    public void checkPage() {
        Assert.assertTrue(driver.findElement(EMAIL_LABEL).isDisplayed(), "Email label must be visible");
        Assert.assertTrue(driver.findElement(NAME_LABEL).isDisplayed(), "Name label must be visible");
        Assert.assertTrue(driver.findElement(EMAIL_INPUT).isDisplayed(), "Email input must be visible");
        Assert.assertTrue(driver.findElement(NAME_INPUT).isDisplayed(), "Name input must be visible");
        Assert.assertTrue(driver.findElement(GENDER_SELECTOR).isDisplayed(), "Gender selector must be visible");
        Assert.assertTrue(driver.findElement(CHECK_BOX_1_1).isDisplayed(), "Checkbox 1.1 must be visible");
        Assert.assertTrue(driver.findElement(CHECK_BOX_1_2).isDisplayed(), "Checkbox 1.2 must be visible");
        Assert.assertTrue(driver.findElement(RADIO_BUTTON_2_1).isDisplayed(), "Radio button 2.1 must be visible");
        Assert.assertTrue(driver.findElement(RADIO_BUTTON_2_2).isDisplayed(), "Radio button 2.2 must be visible");
        Assert.assertTrue(driver.findElement(RADIO_BUTTON_2_3).isDisplayed(), "Radio button 2.3 must be visible");
        Assert.assertTrue(driver.findElement(ADD_BUTTON).isDisplayed(), "Add button must be visible");
        Assert.assertTrue(driver.findElement(DATA_TABLE).isDisplayed(), "Data table must be visible");
    }

    private FormPage clickOnElement(By element) {
        driver.findElement(element).click();
        return this;
    }

    private String getElementText(By element) {
        return driver.findElement(element).getText();
    }
}
