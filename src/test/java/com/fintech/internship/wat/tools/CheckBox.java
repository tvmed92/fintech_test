package com.fintech.internship.wat.tools;

import com.fintech.internship.wat.elementwrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox extends BaseElement {
    private static By activeElementLocator = By.cssSelector("[class='CheckboxWithDescription__checkbox_2E0r_']");
    private WebElement checkBox;

    public CheckBox(WebDriver enclosedDriver, WebElement enclosedElement) {
        super(enclosedDriver, enclosedElement);
        this.checkBox = getEnclosedElement().findElement(activeElementLocator);
    }

//    public boolean isActive() {
////        WebElement checkBox = getEnclosedElement().findElement(activeElementLocator);
//        return checkBox.isSelected();}
//
//    public boolean isInactive() {
////        WebElement checkBox = getEnclosedElement().findElement(activeElementLocator);
//        return !checkBox.isSelected();}

    public void setActive() {
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    public void setInactive() {
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }
}
