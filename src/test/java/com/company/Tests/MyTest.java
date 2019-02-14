package com.company.Tests;

import com.company.Common.Constans;
import com.company.Helpers.HomeHelper;
import com.company.Pages.BasePage;
import com.company.Pages.HomePage;
import org.junit.*;

import java.io.IOException;

public class MyTest extends BaseTest {
    HomePage homePage;
    BasePage basePage;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUA() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_UA);
    }

    @Test
    public void testRU() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_RU);
    }

    @Test
    public void testEN() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_EN);
    }


    public void getAddress(String locale) throws InterruptedException, IOException {
        app.homePage.search();
        app.homePage.uaClickPage();

        app.homePage.getLocale(locale);
        Thread.sleep(1000);
        app.homePage.saveFile(locale);
        app.homePage.compareFiles(locale);
        app.homePage.enClickPage();
        app.homePage.ruClickPage();
        app.homePage.saveFile(locale);
        app.homePage.compareFiles(locale);



    }

}
