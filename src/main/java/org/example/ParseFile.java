package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ParseFile {

    static  String parseFile (String path){
        String result = "";
        try {
            result = Files.readString(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    static Map<String, Contact> parseContactsToMap(String contactsInString){
        String [] contactsInArray = contactsInString.split("\\n");
        Map<String, Contact> contactsInMap = new HashMap<>();
        for (String line : contactsInArray){
            Contact contact = createContactFromLine(line);
            contactsInMap.put(contact.getMailContact(), contact);
        }
        return contactsInMap;
    }

    private static Contact createContactFromLine(String line){
        String [] varContact = line.split(";");
        Contact contact = new Contact();
        contact.setNameContact(varContact[0]);
        contact.setPhoneContact(varContact[1]);
        contact.setMailContact(varContact[2]);
        return contact;
    }
    static void saveInFile (String path, String text){
        try {
            Files.writeString(Path.of(path), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
