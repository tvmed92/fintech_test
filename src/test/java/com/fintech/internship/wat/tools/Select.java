package com.fintech.internship.wat.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.fintech.internship.wat.tools.BaseRunner.clickElement;
import static com.fintech.internship.wat.tools.BaseRunner.driver;

public class Select {

    public static String selectElementFromDropdown(String listName, String value) {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        clickElement("//div[@data-qa-file='UIDropdownSelectActive'][select[@name='"+ listName +"']]");
        By listItems = By.xpath("//div[@class='ui-dropdown-field-list__item']");
        List<WebElement> items = driver.findElements(listItems);
        for (WebElement element : items) {
            if (element.getText().contains(value)) {
                element.click();
                break;
            }
        } return (listName);
    }
}