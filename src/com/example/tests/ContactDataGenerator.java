package com.example.tests;

import com.thoughtworks.xstream.XStream;

import java.io.*;
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

    private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact",ContactData.class);
        String xml = xStream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(ContactData contactData : contacts)
        writer.write(contactData.getName() + "," + contactData.getSurname() + "," + contactData.getGroupName() + ",!" + "\n");
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

    public static List<ContactData> loadContactsFromCSVFile(File file) throws IOException {
        List<ContactData> list = new ArrayList<ContactData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line!=null){
            String[] part = line.split(",");
            ContactData contactData = new ContactData()
                    .withName(part[0])
                    .withSurname(part[1])
                    .withGroupName(part[2]);
            list.add(contactData);
            line = bufferedReader.readLine();
        }
        reader.close();
        return  list;
    }

    public static List<ContactData> loadContactsFromXMLFile(File file) throws IOException {
        XStream xStream = new XStream();
        xStream.alias("contact",GroupData.class);
        return (List<ContactData>) xStream.fromXML(file);
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
