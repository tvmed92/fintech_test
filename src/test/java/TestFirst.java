import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TestFirst extends BaseRunner {

    @Test
    public void testFirst() {
        driver.get(baseUrl);

        clickElement("name");
        clickElement("birthday");
        clickElement("city");
        clickElement("email");
        clickElement("phone");
        clickElement("socialLink0");
        driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon")).click();
        driver.findElement(By.xpath("//button[span[@class='Button__content_3MlYx']]")).click();

        for (int i = 1; i <= 6; i++){
            checkText("(//div[@data-qa-file='UIFormRowError'])["+ i +"]", "Поле обязательное");
        }
    }

    private void checkText(String xpath, String expected) {
        assertEquals(expected,
                driver.findElement(By.xpath(xpath)).getText());
    }

    private void clickElement(String name) {
        driver.findElement(By.name(name)).click();
    }
}
