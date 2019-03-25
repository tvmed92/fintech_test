import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestSecond extends BaseRunner{

    @Test
    public void testSecond() {
        driver.get(baseUrl);

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("ttt");
        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("birthday")).sendKeys("12.12.2020");
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys("123456");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("проха");
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys("+7(000) 000-00-00");

        assertEquals("Допустимо использовать только буквы русского алфавита и дефис",
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals("Мы не нанимаем пришельцев из будущего",
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals("Введите корректный адрес эл. почты",
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9",
                driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }
}
