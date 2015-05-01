package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Tordlin on 01/05/2015.
 */
public abstract class HelperBase {

    protected WebDriver driver;
    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager){
        this.manager = manager;
        this.driver = manager.driver;
    }

    protected void type(By locator, String text) {
        if(text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text) {
        if(text != null){
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }

    protected void selectGroupByIndex(int index) {
        click(By.xpath(".//input[@name='selected[]'][" + index + "]"));
    }
}
