package com.fintech.internship.wat.tools;

import com.fintech.internship.wat.elementwrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {
    private static By activeElementLocator = By.cssSelector("[data-qa-type='uikit/clickable']");
    private WebElement checkBox;

    public CheckBox(WebDriver enclosedDriver, WebElement enclosedElement) {
        super(enclosedDriver, enclosedElement);
        this.checkBox = getEnclosedElement().findElement(activeElementLocator);
    }

    public void setActiveOrInactive() {
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }
}
