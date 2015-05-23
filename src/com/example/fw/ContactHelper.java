package com.example.fw;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tordlin on 01/05/2015.
 */
public class ContactHelper extends HelperBase {

    private List<ContactData> cachedContact;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<ContactData> getContacts() {
        if(cachedContact == null){
            rebuildContactCache();
        }
        return cachedContact;
    }

    public void rebuildContactCache() {
        List<ContactData> cachedContact = new ArrayList<ContactData>();
        List<WebElement> lastNamesTable = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr/td[3]"));
        for(WebElement lastName : lastNamesTable){
            ContactData contact = new ContactData();
            contact.name = lastName.getText();
            cachedContact.add(contact);
        }
    }

    public void fillContactForm(ContactData contactData) {
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
    }

    public void submitContactForm() {
        click(By.name("submit"));
        cachedContact = null;
    }

    public void gotoInitContactPage() {
        click(By.linkText("add new"));
    }

    public void initModifySomeContact(int index) {
        click(By.xpath(".//tbody/tr[" + (2 + index) + "]/td[7]//img"));
    }

    public void deleteContact() {
        click(By.xpath(".//form[@action='delete.php']/input[@name='update']"));
        cachedContact = null;
    }

    public void updateContact() {
        click(By.xpath(".//form[@action='edit.php']/input[@name='update']"));
        cachedContact = null;
    }


}
