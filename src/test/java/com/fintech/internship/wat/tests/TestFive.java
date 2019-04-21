package com.fintech.internship.wat.tests;

//public class TestFive extends BaseRunner {
//
////    @Test
////    public void testFive() {
//        driver.get(tinkoffMobileUrl);
//        new Select(driver, initDropdown("Интернет")).selectElementFromDropdown("0 ГБ");
//        new Select(driver, initDropdown("Звонки")).selectElementFromDropdown("0 минут");
//        new CheckBox(driver, initCheckBox("Мессенджеры")).setActiveOrInactive();
//        new CheckBox(driver, initCheckBox("Социальные сети")).setActiveOrInactive();
//        String price5 = driver.findElement(By.xpath("//h3[@data-qa-file='UITitle']")).getText();
//        Assert.assertEquals(price5, "Общая цена: 0 \u20BD");
//
//        clickElement("//button[@type='button'][span/div[text()='Заказать сим-карту']]");
//        wait.until(d -> {
//            boolean check = false;
//            WebElement element = driver.findElement(By.xpath("//button[@type='button'][span/div[text()='Заказать сим-карту']]"));
//            if (element.isEnabled()) check = true;
//            return check;
//        });
//
//    }
//
//    private WebElement initDropdown(String labelText) {
//        String selector = String.format("//*[@data-qa-file='UIDropdownSelect' and .//*[text()='%s']]", labelText);
//        return driver.findElement(By.xpath(selector));
//    }
//
//    private WebElement initCheckBox(String labelText) {
//        String checkBoxSelector = String.format("//*[@class='CheckboxWithDescription__checkbox_2E0r_'][label[contains(text(), '%s')]]", labelText);
//        return driver.findElement(By.xpath(checkBoxSelector));
//    }
//}
