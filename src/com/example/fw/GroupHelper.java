package com.example.fw;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class GroupHelper extends HelperBase {

    private SortedListOf<GroupData> cachedGroups;

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public SortedListOf<GroupData> getGroups() {
        if(cachedGroups == null){
            rebuildGroupCache();
        }
        return cachedGroups;
    }

    public GroupHelper rebuildGroupCache() {
        manager.navigateTo().groupPage();
        cachedGroups = new SortedListOf<>();
        List<WebElement> checkboxs = driver.findElements(By.name("selected[]"));
        for(WebElement checkbox : checkboxs){
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            cachedGroups.add(new GroupData().withName(name));
        }
        return this;
    }

    public GroupHelper createGroup(GroupData groupData) {
        manager.navigateTo().groupPage();
        initGroupPage();
        fillGroupForm(groupData);
        submitGroupCreation();
        returnToGroupPage();
        rebuildGroupCache();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData groupData) {
        manager.navigateTo().groupPage();
        initGroupModification(index);
        fillGroupForm(groupData);
        submitGroupModification();
        returnToGroupPage();
        rebuildGroupCache();
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        manager.navigateTo().groupPage();
        deleteSomeGroup(index);
        returnToGroupPage();
        rebuildGroupCache();
        return this;
    }

    public GroupHelper returnToGroupPage() {
        click(By.linkText("group page"));
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    public GroupHelper initGroupPage() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper deleteSomeGroup(int index) {
        selectGroupByIndex(index);
        click(By.name("delete"));
        cachedGroups = null;
        return this;
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.name("edit"));
        return  this;
    }

    public GroupHelper submitGroupModification() {
        click(By.name("update"));
        cachedGroups = null;
        return this;
    }

    protected void selectGroupByIndex(int index) {
        click(By.xpath(".//input[@name='selected[]'][" + (index + 1) + "]"));
    }


}

