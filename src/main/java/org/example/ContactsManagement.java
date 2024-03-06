package org.example;

import java.util.*;

public class ContactsManagement {


    void showContacts(Map<String, Contact> contactsInMap) {
        Collection<Contact> contactsInSet = contactsInMap.values();
        for (Contact contact : contactsInSet) {
            System.out.println(contact.getNameContact() + ";" + contact.getPhoneContact() + ";" + contact.getMailContact());
        }
    }

    Map<String, Contact> addContact(Map<String, Contact> contactsInMap) {
        Contact contact = new Contact();
        System.out.println("Введите имя контакта:");
        Scanner scanner = new Scanner(System.in);
        String nameContact = scanner.next();
        while (true) {
            System.out.println("Введите номер контакта:");
            String phoneContact = scanner.next();
            if (phoneContact.matches("[+]?\\d+")) {
                contact.setPhoneContact(phoneContact);
                break;
            }
            System.out.println("Неверный формат номера");
        }
        System.out.println("Введите электронную почту контакта:");
        String mailContact = scanner.next();
        contact.setNameContact(nameContact);
        contact.setMailContact(mailContact);
        contactsInMap.put(mailContact, contact);
        System.out.println("Контакт успешно добавлен");
        return contactsInMap;
    }

    Map<String, Contact> deleteContact(Map<String, Contact> contactsInMap) {
        System.out.println("Введите mail контакта, который хотите удалить:");
        Scanner scanner = new Scanner(System.in);
        String mail = scanner.next();
        if (!contactsInMap.containsKey(mail)) {
            System.out.println("По данному mail контакт не найден");
            return contactsInMap;
        }
        System.out.println("Контакт " + contactsInMap.get(mail).printInfoAboutContact() + " удален");
        contactsInMap.remove(mail);
        return contactsInMap;
    }

    String MapToStringContacts(Map<String, Contact> contactsInMap) {
        String text = "";
        Collection<Contact> contacts = contactsInMap.values();
        for (Contact contact : contacts) {
            text = text + contact.printInfoAboutContact() + "\n";
        }
        return text;
    }
}
