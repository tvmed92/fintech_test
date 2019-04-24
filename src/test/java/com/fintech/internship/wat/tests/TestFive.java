package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.pages.TinkoffMobilePage;
import org.junit.Assert;
import org.junit.Test;

public class TestFive extends BaseRunner {

    @Test
    public void testFive() {
        TinkoffMobilePage mobile = testApp.mobilePage;
        mobile.openMobile();
        mobile.setMinValues();
        String price = mobile.getPrice();
        Assert.assertEquals(price, "Общая цена: 0 \u20BD");
        mobile.checkButtonAvailability();
    }
}

