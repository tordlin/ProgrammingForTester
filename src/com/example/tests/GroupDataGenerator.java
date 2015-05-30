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
public class GroupDataGenerator {
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

        List<GroupData> groups = generateRandomGroups(amount);
        if("csv".equals(format)){
            saveGroupsToCSVFile(groups, file);
        } else if("xml".equals(format)){
            saveGroupsToXMLFile(groups, file);
        } else {
            System.out.println("Unknown format " + format);
            return;
        }

    }

    private static void saveGroupsToXMLFile(List<GroupData> groups, File file) {

    }

    private static void saveGroupsToCSVFile(List<GroupData> groups, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for(GroupData groupData : groups)
        writer.write(groupData.getName() + "," + groupData.getHeader() + "," + groupData.getFooter() + "\n");
        writer.close();
    }

    public static List<GroupData> generateRandomGroups(int amount) {
        List<GroupData> list = new ArrayList<GroupData>();
        for (int i = 0; i < amount; i++) {
            GroupData groupData = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(groupData);
        }
        return list;
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
