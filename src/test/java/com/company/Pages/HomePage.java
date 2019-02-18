package com.company.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {
    @FindBy(xpath = ".//a[contains(@href, 'contacts')]")
    private WebElement pureMenuLink;
    @FindBy(xpath = "//li/a[contains(@title, 'UA')]")
    private WebElement uaClick;
    @FindBy(xpath = "//li/a[contains(@title, 'en')]")//en
    private WebElement enClick;
    @FindBy(xpath = "//li/a[contains(@title, 'ru')]")//ru
    private WebElement ruClick;
    @FindBy(xpath = "/html/body/section[2]/div[2]/div[1]/div")
    private WebElement contacts;
    @FindBy(xpath = ".//*[@id='locale-link']/parent::li")
    private WebElement clickLocale;

    public void getLocale(String locale) {
        String xp = "//li/a[contains(@title, '" + locale + "')]";
        WebElement elem = driver.findElement(By.xpath(xp));
        System.out.println(xp);
        elem.click();
    }

    public void search() {
        pureMenuLink.click();
    }

    public void uaClickPage() {
        uaClick.click();
    }
     public void ruClickPage() {
        ruClick.click();
    }

    public void enClickPage() {
        enClick.click();
    }

    public void localeClick(){clickLocale.click();}
    /*public void ClickPage(WebElement elem, String locale) {
        elem = getLocale(locale);
        elem.click();
    }*/

    public void saveFile(String locale) throws IOException {
        ArrayList<String> resultText = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='section-contacts']/div[2]/div[1]/div"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
            resultText.add(element.getText());
        }
        FileWriter fileWriter = new FileWriter("expected" + locale + ".txt");
        for (String line : resultText) {
            fileWriter.write(line);
            fileWriter.write(System.getProperty("line.separator"));
        }
        fileWriter.close();
    }


    public void compareFiles(String locale) throws IOException {

        File f1 = new File("actual" + locale + ".txt");
        File f2 = new File("expected" + locale + ".txt");
        try {
            if (f1.exists() && f2.exists()) {
                List<String> file1 = Files.readAllLines(Paths.get("actual" + locale + ".txt"));
                List<String> file2 = Files.readAllLines(Paths.get("expected" + locale + ".txt"));
                assertEquals(file1.size(), file2.size());
                for (int i = 0; i < file1.size(); i++) {
                    System.out.println("Comparing line: " + i);
                    assertEquals(file1.get(i), file2.get(i));
                }
            }
            throw new FileNotFoundException("File was not found in TRY block");
        } catch (IOException e) {
            System.out.println("File was found");
        }
    }

}


