package com.example.fw;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class ContactHelper extends HelperBase {

    private SortedListOf<ContactData> cachedContact;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public SortedListOf<ContactData> getContacts() {
        if(cachedContact == null){
            rebuildContactCache();
        }
        return cachedContact;
    }

    public ContactHelper rebuildContactCache() {
        manager.navigateTo().mainPage();
        cachedContact = new SortedListOf<>();
        List<WebElement> lastNamesTable = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr/td[3]"));
        for(WebElement lastName : lastNamesTable){
            ContactData contact = new ContactData();
            contact.name = lastName.getText();
            cachedContact.add(contact);
        }
        return this;
    }

    public ContactHelper createContact(ContactData contactData) {
        manager.navigateTo().mainPage();
        gotoInitContactPage();
        fillContactForm(contactData);
        submitContactForm();
        gotoHomePage();
        rebuildContactCache();
        return this;
    }

    public ContactHelper removeContact(int index) {
        manager.navigateTo().mainPage();
        initModifySomeContact(index);
        deleteContact();
        gotoHomePage();
        rebuildContactCache();
        return this;
    }

    public ContactHelper modifyContact(int index, ContactData contactData) {
        manager.navigateTo().mainPage();
        initModifySomeContact(index);
        fillContactForm(contactData);
        updateContact();
        gotoHomePage();
        rebuildContactCache();
        return this;
    }

    public ContactHelper fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomeNumber());
        type(By.name("mobile"), contactData.getMobileNumber());
        type(By.name("work"), contactData.getWorkNumber());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        selectByText(By.name("bday"), contactData.getBday());
        selectByText(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        selectByText(By.name("new_group"), contactData.getGroupName());
        type(By.name("address2"), contactData.getSecondaryAddress());
        type(By.name("phone2"), contactData.getSecondaryPhone());
        return this;
    }

    public ContactHelper submitContactForm() {
        click(By.name("submit"));
        cachedContact = null;
        return this;
    }

    public ContactHelper gotoInitContactPage() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper initModifySomeContact(int index) {
        click(By.xpath(".//tbody/tr[" + (2 + index) + "]/td[7]//img"));
        return this;
    }

    public ContactHelper deleteContact() {
        click(By.xpath(".//form[@action='delete.php']/input[@name='update']"));
        cachedContact = null;
        return this;
    }

    public ContactHelper updateContact() {
        click(By.xpath(".//form[@action='edit.php']/input[@name='update']"));
        cachedContact = null;
        return this;
    }

    public ContactHelper gotoHomePage() {
        click(By.linkText("home page"));
        return this;
    }


}
