package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void mainPage() {
        if(!onMainPage()) {
            click(By.linkText("home"));
        }
    }

    private boolean onMainPage(){
        return  driver.findElements(By.id("maintable")).size() > 0;
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void groupPage() {
        if(!onGroupsPage()){
            click(By.linkText("groups"));
        }
    }

    private boolean onGroupsPage(){
        if(driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size() > 0){
            return true;
        }else{
            return false;
        }
    }

    protected void selectGroupByIndex(int index) {
        click(By.xpath(".//input[@name='selected[]'][" + (index + 1) + "]"));
    }
}
