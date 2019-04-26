package com.fintech.internship.wat.pages;

import com.fintech.internship.wat.tools.CheckBox;
import com.fintech.internship.wat.tools.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TinkoffMobilePage extends Page {
    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openMobile() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleContains("Тарифы Тинькофф Мобайла");
    }

    @Override
    public void switchToTab(String windowTitle) {
        wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                System.out.println(d.getTitle());
                check = d.getTitle().equals(windowTitle);
            }
            return check;
        });
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void checkCityIsRight(String cityName) {
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='" + cityName + "']"));
        Assert.assertTrue(element.isDisplayed());
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void setMaxValues() {
        new Select(driver, initDropdown("Интернет")).selectElementFromDropdown("Безлимитный интернет");
        new Select(driver, initDropdown("Звонки")).selectElementFromDropdown("Безлимитные минуты");
        new CheckBox(driver, initCheckBox("Режим модема")).setActiveOrInactive();
        new CheckBox(driver, initCheckBox("Безлимитные СМС")).setActiveOrInactive();
    }

    public void setMinValues() {
        new Select(driver, initDropdown("Интернет")).selectElementFromDropdown("0 ГБ");
        new Select(driver, initDropdown("Звонки")).selectElementFromDropdown("0 минут");
        new CheckBox(driver, initCheckBox("Мессенджеры")).setActiveOrInactive();
        new CheckBox(driver, initCheckBox("Социальные сети")).setActiveOrInactive();
    }

    private WebElement initDropdown(String labelText) {
        String selector = String.format("//*[@data-qa-file='UIDropdownSelect' and .//*[text()='%s']]", labelText);
        return driver.findElement(By.xpath(selector));
    }

    private WebElement initCheckBox(String labelText) {
        String checkBoxSelector = String.format(
                "//*[@class='CheckboxWithDescription__checkbox_2E0r_'][label[contains(text(),'%s')]]", labelText);
        return driver.findElement(By.xpath(checkBoxSelector));
    }

    public void setCity(String cityName) {
        clickElement("//div[@class='MvnoRegionConfirmation__title_DOqnW']");
        clickElement("//div[@class='Text__text_3OSYn'][text()='" + cityName + "']");
    }

    public String getPrice() {
        return driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
    }

    public void checkButtonAvailability() {
        clickElement("//button[@type='button'][span/div[text()='Заказать сим-карту']]");
        wait.until(d -> {
            boolean check = false;
            WebElement element = driver.findElement(By.xpath("//button[@type='button'][span/div[text()='Заказать сим-карту']]"));
            if (element.isEnabled()) check = true;
            return check;
        });
    }
}
