package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import com.fintech.internship.wat.tools.CheckBox;
import com.fintech.internship.wat.tools.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestFive extends BaseRunner {

    @Test
    public void testFive() {
        driver.get(tinkoffMobileUrl);
        new Select(driver, initDropdown("Интернет")).selectElementFromDropdown("0 ГБ");
        new Select(driver, initDropdown("Звонки")).selectElementFromDropdown("0 минут");
        new CheckBox(driver, initCheckBox("Мессенджеры (59 \u20BD)")).setInactive();
        new CheckBox(driver,initCheckBox("Социальные сети (59 \u20BD)")).setInactive();
        String price5 = driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
        Assert.assertEquals(price5, "Общая цена: 0 \u20BD");

        clickElement("//button[@type='button'][span/div[text()='Заказать сим-карту']]");
        wait.until(d -> {
            boolean check = false;
            WebElement element = driver.findElement(By.xpath("//button[@type='button'][span/div[text()='Заказать сим-карту']]"));
            if (element.isEnabled()) check = true;
            return check;
        });

    }

//    private void setDeactivateCheckBox(String labelName) {
//        driver.findElement(By.xpath("//label[text()='" + labelName + "']")).click();
//    }

    private WebElement initDropdown(String labelText) {
        String selector = String.format("//*[@data-qa-file='UIDropdownSelect' and .//*[text()='%s']]", labelText);
        return driver.findElement(By.xpath(selector));
    }

    private WebElement initCheckBox(String labelText) {
        String checkBoxSelector = String.format("//*[@class='CheckboxSet__checkboxSet_1aOBh' and .//*[text()='%s']]", labelText);
        return driver.findElement(By.xpath(checkBoxSelector));
    }
}
