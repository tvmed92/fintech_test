package com.fintech.internship.wat.tests;


import com.fintech.internship.wat.pages.TinkoffMobilePage;
import org.junit.Assert;
import org.junit.Test;

public class TestFourth extends BaseRunner {

    @Test
    public void testFourth() {
        TinkoffMobilePage mobile = testApp.mobilePage;
        mobile.openMobile();
        mobile.clickElement("//span[@class='MvnoRegionConfirmation__option_v9PfP']");
        mobile.checkCityIsRight("Москва и Московская область");
        mobile.refreshPage();
        mobile.checkCityIsRight("Москва и Московская область");

        String price1 = mobile.getPrice();
        mobile.setCity("Краснодарский кр.");
        String price2 = mobile.getPrice();
        Assert.assertNotSame(price1, price2);

        mobile.setMaxValues();
        String price3 = mobile.getPrice();
        mobile.setCity("Москва и Московская обл.");
        mobile.setMaxValues();
        String price4 = mobile.getPrice();
        Assert.assertEquals(price3, price4);
    }
}
