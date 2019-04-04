package com.fintech.internship.wat.tools;

import com.fintech.internship.wat.elementwrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Select extends BaseElement {

    private By activeElementLocator = By.cssSelector("[data-qa-file=UIDropdownSelectActive]");
    private By listItemLocator = By.cssSelector("[data-qa-file=UIDropdownItemEventHandler]");
    public Select(WebDriver enclosedDriver, WebElement enclosedElement) {
        super(enclosedDriver, enclosedElement);
    }

    public void expandDropdown() {
        getEnclosedElement().findElement(activeElementLocator).click();
    }

    public List<WebElement> getListItems(){
        return getEnclosedElement().findElements(listItemLocator);
    }

    public void selectElementFromDropdown(String value) {
//        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
//        super.getEnclosedElement().click();
//        clickElement("//div[@data-qa-file='UIDropdownSelectActive'][select[@name='"+ listName +"']]");
//        By listItems = By.xpath("//div[@class='ui-dropdown-field-list__item']");
        expandDropdown();
        List<WebElement> items = getListItems();
        for (WebElement element : items) {
            if (element.getText().contains(value)) {
                element.click();
                break;
            }
        }
    }
}