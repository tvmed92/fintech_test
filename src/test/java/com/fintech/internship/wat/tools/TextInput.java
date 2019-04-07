package com.fintech.internship.wat.tools;

import com.fintech.internship.wat.elementwrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput extends BaseElement {
    private By activeElementLocator = By.xpath("//*[@class='ui-input__field']");

    public TextInput(WebDriver enclosedDriver, WebElement enclosedElement) {
        super(enclosedDriver, enclosedElement);
    }

    public void sendKeys(String value) {
        getEnclosedElement().findElement(activeElementLocator).sendKeys(value);
    }

    public String getCurrentValue(String value) {
        return getEnclosedElement().getAttribute(value);
    }

}
