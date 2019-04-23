package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.pages.TinkoffVacanciesPage;
import org.junit.Test;

public class TestFirst extends BaseRunner {

    @Test
    public void testFirst() {
        TinkoffVacanciesPage vacancies = testApp.vacanciesPage;
        vacancies.openVacancies();

        vacancies.clickElementByName("name");
        vacancies.clickElementByName("birthday");
        vacancies.clickElementByName("city");
        vacancies.clickElementByName("email");
        vacancies.clickElementByName("phone");
        vacancies.clickElementByName("socialLink0");
        vacancies.clickElementByCss("svg.ui-icon-checkbox.ui-checkbox__icon");
        vacancies.clickElementByXpath("//button[span[@class='Button__content_3MlYx']]");

        for (int i = 1; i <= 6; i++) {
            vacancies.checkText("(//div[@data-qa-file='UIFormRowError'])[" + i + "]", "Поле обязательное");
        }
    }
}
