package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.pages.TinkoffVacanciesPage;
import org.junit.Test;

public class TestSecond extends BaseRunner {

    @Test
    public void testSecond() {
        TinkoffVacanciesPage vacancies = testApp.vacanciesPage;
        vacancies.openVacancies();

        vacancies.inputTextToField("Фамилия и имя", "ttt");
        vacancies.inputTextToField("Дата рождения", "12.12.2020");
        vacancies.inputTextToField("Город проживания", "123456");
        vacancies.inputTextToField("Электронная почта", "пролдж");
        vacancies.inputTextToField("Мобильный телефон", "+7(000) 000-00-00");
        vacancies.clickSendButton();

        vacancies.checkErrorText("Фамилия и имя", "Допустимо использовать только буквы русского алфавита и дефис");
        vacancies.checkErrorText("Дата рождения", "Вам должно быть от 16 до 100 лет");
        vacancies.checkErrorText("Электронная почта", "Введите корректный адрес эл. почты");
        vacancies.checkErrorText("Мобильный телефон", "Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

        vacancies.clearField("Дата рождения");
        vacancies.inputTextToField("Дата рождения", "41.12.2018");
        vacancies.clickSendButton();
        vacancies.checkErrorText("Дата рождения", "Поле заполнено некорректно");
    }
}
