package models.user;

import enums.UserRole;

public abstract class User {
    String name;
    UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }
}
