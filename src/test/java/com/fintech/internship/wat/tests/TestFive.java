package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.tools.BaseRunner;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestFive extends BaseRunner {

    @Test
    public void testFive() {
        driver.get(tinkoffMobileUrl);
        selectElementFromDropdown("internet", "0 ГБ");
        selectElementFromDropdown("calls", "0 минут");
        setDeactivateCheckBox("Мессенджеры (59 \u20BD)");
        setDeactivateCheckBox("Социальные сети (59 \u20BD)");
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

    private void selectElementFromDropdown(String listName, String value) {
        clickElement("//div[@data-qa-file='UIDropdownSelectActive'][select[@name='" + listName + "']]");
        By listItems = By.xpath("//div[@class='ui-dropdown-field-list__item']");
        List<WebElement> items = driver.findElements(listItems);
        for (WebElement element : items) {
            if (element.getText().contains(value)) {
                element.click();
                break;
            }
        }
    }

    private void setDeactivateCheckBox(String labelName) {
        driver.findElement(By.xpath("//label[text()='" + labelName + "']")).click();
    }
}
