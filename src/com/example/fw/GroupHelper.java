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

    private List<GroupData> cachedGroups;

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<GroupData> getGroups() {
        if(cachedGroups == null){
            rebuildGroupCache();
        }
        return cachedGroups;
    }

    public void rebuildGroupCache() {
        cachedGroups = new ArrayList<GroupData>();
        List<WebElement> checkboxs = driver.findElements(By.name("selected[]"));
        for(WebElement checkbox : checkboxs){
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.name = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroups.add(group);
        }
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
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
        cachedGroups = null;
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
    }

    protected void selectGroupByIndex(int index) {
        click(By.xpath(".//input[@name='selected[]'][" + (index + 1) + "]"));
    }
}

