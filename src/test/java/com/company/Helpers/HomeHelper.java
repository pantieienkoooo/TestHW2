package com.company.Helpers;

import com.company.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class HomeHelper extends HomePage {
//    WebDriver wait = new WebDriver(driver, 60);


        /* public void resultList() throws IOException{
             result();
         }*/
        public void closeApp() {
            driver.quit();
        }
    }



