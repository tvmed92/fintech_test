package com.fintech.internship.wat.tests;

import com.fintech.internship.wat.app.TestApplication;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BaseRunner {
    public static ThreadLocal<TestApplication> thlTestApp = new ThreadLocal<>();

    public TestApplication testApp;
    protected String tinkoffMobileUrl;
    protected String tinkoffVacanciesUrl;

    @Before
    public void setUp() {
        if (thlTestApp.get() != null) {
            testApp = thlTestApp.get();
            return;
        }
        testApp = new TestApplication();
        thlTestApp.set(testApp);

        tinkoffVacanciesUrl = "https://www.tinkoff.ru/career/vacancies/";
        tinkoffMobileUrl = "https://www.tinkoff.ru/mobile-operator/tariffs/";
    }

    @After
    public void tearDown() {
        testApp.quit();
    }

}