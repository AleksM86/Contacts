package org.example;

import lombok.Data;

@Data
public class Contact {
    private String nameContact;
    private String phoneContact;
    private String mailContact;

    String printInfoAboutContact(){
        return nameContact + ";" + phoneContact + ";" + mailContact;
    }
}
