package models.user;

import enums.UserRole;

public abstract class User {
    String name;
    UserRole role;

    protected User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }
}
