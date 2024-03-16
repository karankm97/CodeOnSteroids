package org.example.model;

import lombok.Getter;

@Getter
public class Contact {
    String phone;
    String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}
