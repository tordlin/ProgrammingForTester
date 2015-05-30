package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tordlin on 30/05/2015.
 */
public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        if(args.length < 3){
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }
        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if(file.exists()){
            System.out.println("File " + file + " exists. Please remove it manually.");
        }

        List<ContactData> contacts = generateRandomContacts(amount);
        if("csv".equals(format)){
            saveContactsToCSVFile(contacts, file);
        } else if("xml".equals(format)){
            saveContactsToXMLFile(contacts, file);
        } else {
            System.out.println("Unknown format " + format);
            return;
        }

    }

    private static void saveContactsToXMLFile(List<ContactData> contacts, File file) {

    }

    private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(ContactData contactData : contacts)
        writer.write(contactData.getName() + "," + contactData.getSurname() + "," + contactData.getGroupName() + "\n");
        writer.close();
    }

    public static List<ContactData> generateRandomContacts(int amount) {
        List<ContactData> list = new ArrayList<ContactData>();
        for(int i = 0; i < amount; i++){
            ContactData contactData = new ContactData()
                    .withName(generateRandomString())
                    .withSurname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHomeNumber("00" + i)
                    .withMobileNumber("00" + i)
                    .withWorkNumber("00" + i)
                    .withEmail1("test" + i + "@mail.ru")
                    .withEmail2("test2" + i + "@mail.ru")
                    .withBDay("1")
                    .withBMonth("January")
                    .withBYear("2000")
                    .withGroupName("GroupName1")
                    .withSecondaryAddress(generateRandomString())
                    .withSecondaryPhone(generateRandomString());
            list.add(contactData);
        }
        return  list;
    }

    public static String generateRandomString(){
        Random rnd = new Random();
        if(rnd.nextInt(4) == 0){
            return "";
        }else{
            return "test" + rnd.nextInt();
        }
    }
}
