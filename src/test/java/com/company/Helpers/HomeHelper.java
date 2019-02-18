package com.company.Helpers;

import com.company.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.company.Common.Constans.BASE_URL;

public class HomeHelper extends HomePage {
//    WebDriver wait = new WebDriver(driver, 60);


        /* public void resultList() throws IOException{
             result();
         }*/
        public void closeApp() {
            driver.quit();
        }
        public void driverStart(){driver.get(BASE_URL);}
    }



