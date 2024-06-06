package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    private final String id;
    private final String name;
    @Setter
    private String email;
    @Setter
    private String phone;
}
