package com.fintech.internship.wat.tests;

//public class TestSecond extends BaseRunner {
//
//    @Test
//    public void testSecond() {
//        driver.get(tinkoffVacanciesUrl);
//
//        new TextInput(driver, initTextField("Фамилия и имя")).sendKeys("ttt");
//        new TextInput(driver, initTextField("Дата рождения")).sendKeys("12.12.2020");
//        new TextInput(driver, initTextField("Город проживания")).sendKeys("123456");
//        new TextInput(driver, initTextField("Электронная почта")).sendKeys("пролдж");
//        new TextInput(driver, initTextField("Мобильный телефон")).sendKeys("+7(000) 000-00-00");
//        clickElementByName("//button[span[@class='Button__content_3MlYx']]");
//
//        checkText("Фамилия и имя", "Допустимо использовать только буквы русского алфавита и дефис");
//        checkText("Дата рождения", "Мы не нанимаем пришельцев из будущего");
//        checkText("Электронная почта", "Введите корректный адрес эл. почты");
//        checkText("Мобильный телефон", "Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");
//
//        driver.findElement(By.xpath("//*[@class='ui-input__label'][span[contains(text(),'Дата рождения')]]")).clear();
//        new TextInput(driver, initTextField("Дата рождения")).sendKeys("41.12.2018");
//        clickElementByName("//button[span[@class='Button__content_3MlYx']]");
//        checkText("Дата рождения", "Поле заполнено некорректно");
//
//    }
//
//    private WebElement initTextField(String labelName) {
//        String textInputSelector = String.format("//*[@class='ui-input__label'][span[contains(text(),'%s')]]", labelName);
//        return driver.findElement(By.xpath(textInputSelector));
//    }

//}
