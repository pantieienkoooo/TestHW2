package com.company.Tests;

import com.company.Common.Constans;
import com.company.Helpers.HomeHelper;
import com.company.Pages.BasePage;
import com.company.Pages.HomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.company.Common.Constans.BASE_URL;

public class MyTest extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public static void beforeClass() {
    app.homePage.driverStart();
    }



    @Test
    public void testUA001() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_UA);
    }

    @Test
    public void testRU002() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_RU);
    }

    @Test
    public void testEN003() throws IOException, InterruptedException {
        getAddress(Constans.LOCALE_EN);
    }
    @AfterClass
    public static void afterClass(){
        app.homePage.closeApp();
    }

    public void getAddress(String locale) throws InterruptedException, IOException {
        app.homePage.search();
        //app.homePage.localeClick();
        //  app.homePage.uaClickPage();
        // app.homePage.getLocale(locale);
        Thread.sleep(1000);
        app.homePage.localeClick();
        app.homePage.getLocale(locale);
         app.homePage.saveFile(locale);
        app.homePage.compareFiles(locale);


        /*app.homePage.saveFile(locale);
        app.homePage.compareFiles(locale);
        app.homePage.localeClick();
        app.homePage.getLocale(locale);
        app.homePage.saveFile(locale);
        app.homePage.compareFiles(locale);
        app.homePage.closeApp();*/

    }

}

