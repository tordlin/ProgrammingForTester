package com.example.fw;

import org.openqa.selenium.By;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/index.php");
        click(By.linkText("home"));
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

}
