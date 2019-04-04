package com.fintech.internship.wat.elementwrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    public WebDriver getEnclosedDriver() {
        return enclosedDriver;
    }

    public WebElement getEnclosedElement() {
        return enclosedElement;
    }

    private WebDriver enclosedDriver;
    private WebElement enclosedElement;

    public BaseElement(WebDriver enclosedDriver, WebElement enclosedElement) {
        this.enclosedDriver = enclosedDriver;
        this.enclosedElement = enclosedElement;
    }
}
