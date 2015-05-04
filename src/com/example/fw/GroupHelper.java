package com.example.fw;

import com.example.tests.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteSomeGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxs = driver.findElements(By.name("selected[]"));
        for(WebElement checkbox : checkboxs){
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.name = title.substring("Select (".length(), title.length() - ")".length());
            groups.add(group);
        }
        return groups;
    }

    protected void selectGroupByIndex(int index) {
        click(By.xpath(".//input[@name='selected[]'][" + (index + 1) + "]"));
    }
}

