package org.example;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Scanner;

public class InitWorkWithContacts implements StartWork {
    @Value("${app.path}")
    private  String path;
    private String contactsInString;
    private Map<String, Contact> contactsInMap;
    private ContactsManagement contactsManagement;

    @Override
    public void startWork() {
        commands();
        contactsInString = ParseFile.parseFile(path);
        contactsInMap = ParseFile.parseContactsToMap(contactsInString);
        contactsManagement = new ContactsManagement();
        usersCommand();
    }

    private void commands() {
        System.out.println("Команды приложения: ");
        System.out.println("show - показать контакты");
        System.out.println("add - добавить контакт");
        System.out.println("delete - удаляет контакт");
    }

    private void usersCommand() {
        System.out.println("Введите команду: ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        if (command.equals("show")) {
            contactsManagement.showContacts( contactsInMap);
        }
        if (command.equals("add")) {
            contactsInMap = contactsManagement.addContact(contactsInMap);
            ParseFile.saveInFile(path, contactsManagement.MapToStringContacts(contactsInMap));
        }
        if (command.equals("delete")) {
            contactsInMap = contactsManagement.deleteContact(contactsInMap);
            ParseFile.saveInFile(path, contactsManagement.MapToStringContacts(contactsInMap));
        }
        if (command.equals("stop")) {
            System.out.println("Приложение закрыто");
            return;
        }
        if (!command.equals("show") && !command.equals("add") && !command.equals("delete")) {
            System.out.println("Неизвестная команда:");
        }
        usersCommand();
    }
}