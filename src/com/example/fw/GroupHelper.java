package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupPage() {
        click(By.name("new"));
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }
}
