package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import com.fintech.internship.wat.tools.CheckBox;
import com.fintech.internship.wat.tools.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestFourth extends BaseRunner {

    @Test
    public void testFourth() {
        driver.get(tinkoffMobileUrl);

        clickElement("//span[@class='MvnoRegionConfirmation__option_v9PfP']");
        checkCityIsRight("Москва и Московская область");

        driver.navigate().refresh();
        checkCityIsRight("Москва и Московская область");

        String price1 = getPrice();
        setCity("Краснодарский кр.");
        String price2 = getPrice();
        Assert.assertNotSame(price1, price2);

        setMaxValues();
        String price3 = getPrice();
        setCity("Москва и Московская обл.");
        setMaxValues();
        String price4 = getPrice();
        Assert.assertEquals(price3, price4);

    }

    private WebElement initDropdown(String labelText) {
        String selector = String.format("//*[@data-qa-file='UIDropdownSelect' and .//*[text()='%s']]", labelText);
        return driver.findElement(By.xpath(selector));
    }

    private WebElement initCheckBox(String labelText) {
        String checkBoxSelector = String.format("//*[@class='CheckboxWithDescription__checkbox_2E0r_'][label[contains(text(), '%s')]]", labelText);
        return driver.findElement(By.xpath(checkBoxSelector));
    }

    private void setMaxValues() {
        new Select(driver, initDropdown("Интернет")).selectElementFromDropdown("Безлимитный интернет");
        new Select(driver, initDropdown("Звонки")).selectElementFromDropdown("Безлимитные минуты");
        new CheckBox(driver, initCheckBox("Режим модема")).setActive();
        new CheckBox(driver, initCheckBox("Безлимитные СМС")).setActive();
    }

    private String getPrice() {
        return driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
    }

    private void checkCityIsRight(String cityName) {
        WebElement element = driver.findElement(By.xpath(
                "//div[@class='MvnoRegionConfirmation__title_DOqnW'][text()='" + cityName +"']"));
        Assert.assertTrue(element.isDisplayed());
    }

    private void setCity(String cityName) {
        clickElement("//div[@class='MvnoRegionConfirmation__title_DOqnW']");
        clickElement("//div[@class='Text__text_3OSYn'][text()='" + cityName + "']");
    }
}
